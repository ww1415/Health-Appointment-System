import java.time.LocalTime;

/**
 * Part4: Model one single appointment
 */
public class Appointment implements Comparable<Appointment> {
    private String patientName;
    private String patientMobile;
    private HealthProfessional selectedProfessional;
    private LocalTime appointmentTime;

    // All parameters required, cannot create incomplete appointment
    public Appointment(String patientName, String patientMobile, HealthProfessional selectedProfessional, LocalTime appointmentTime) {
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.selectedProfessional = selectedProfessional;
        this.appointmentTime = appointmentTime;
    }

    // Getters
    public String getPatientName() {
        return patientName;
    }
    public String getPatientMobile() {
        return patientMobile;
    }
    public HealthProfessional getSelectedProfessional() {
        return selectedProfessional;
    }
    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    // Sort appointments by time
    @Override
    public int compareTo(Appointment other) {
        return this.appointmentTime.compareTo(other.appointmentTime);
    }

    @Override
    public String toString() {
        return "Appointment{Patient:'" + patientName + "', Mobile:'" + patientMobile
                + "', Time:" + appointmentTime
                + ", Practitioner:" + selectedProfessional.getName() + "(ID:" + selectedProfessional.getId() +")}";
    }
}
