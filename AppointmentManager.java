import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Part5: Manage collection of appointments
 */
public class AppointmentManager {
    private List<Appointment> allAppointments;
    public static final LocalTime CLINIC_START = LocalTime.of(8,0);
    public static final LocalTime CLINIC_END = LocalTime.of(16,0);

    public AppointmentManager() {
        allAppointments = new ArrayList<>();
    }

    public String addAppointment(Appointment appointment){
        if(appointment == null){
            return "Add failed: appointment object cannot be null.";
        }
        LocalTime time = appointment.getAppointmentTime();
        if(time.isBefore(CLINIC_START) || time.isAfter(CLINIC_END)){
            return "Add failed: time outside clinic opening hours (08:00-16:00).";
        }
        int minute = time.getMinute();
        if(!(minute == 0 || minute ==30)){
            return "Add failed: only 30-minute time slots allowed.";
        }
        // Check double-booking
        for(Appointment apt : allAppointments){
            if(apt.getSelectedProfessional().equals(appointment.getSelectedProfessional())
                    && apt.getAppointmentTime().equals(appointment.getAppointmentTime())){
                return "Add failed: this practitioner is already booked for this time slot.";
            }
        }
        allAppointments.add(appointment);
        return "Add appointment success.";
    }

    public List<Appointment> getAllAppointments(){
        return new ArrayList<>(allAppointments);
    }

    public List<Appointment> getAllSortedByTime(){
        List<Appointment> copy = new ArrayList<>(allAppointments);
        Collections.sort(copy);
        return copy;
    }

    // filter by professional id
    public List<Appointment> filterByProfessionalId(int professionalId){
        List<Appointment> result = new ArrayList<>();
        for(Appointment apt : allAppointments){
            if(apt.getSelectedProfessional().getId() == professionalId){
                result.add(apt);
            }
        }
        return result;
    }

    // filter by patient mobile number
    public List<Appointment> filterByPatientMobile(String mobile){
        List<Appointment> result = new ArrayList<>();
        for(Appointment apt : allAppointments){
            if(apt.getPatientMobile().equals(mobile)){
                result.add(apt);
            }
        }
        return result;
    }

    public String cancelByProfessionalAndTime(int proId, LocalTime time){
        for(int i=0; i<allAppointments.size(); i++){
            Appointment apt = allAppointments.get(i);
            if(apt.getSelectedProfessional().getId() == proId && apt.getAppointmentTime().equals(time)){
                allAppointments.remove(i);
                return "Cancel appointment success.";
            }
        }
        return "Cancel failed: matching appointment not found.";
    }

    public String cancelByPatientMobile(String mobile){
        List<Appointment> toRemove = filterByPatientMobile(mobile);
        if(toRemove.isEmpty()){
            return "Cancel failed: no appointments found for this mobile number.";
        }
        allAppointments.removeAll(toRemove);
        return "Cancel success: removed all appointments for this patient.";
    }
}
