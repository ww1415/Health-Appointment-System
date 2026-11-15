import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

/**
 * Main entry point, Part3 and Part6 demonstration
 */
public class AssignmentOne {
    public static void main(String[] args) {
        // ========= Part3: Work with health professionals =========
        System.out.println("========== Part3: All Health Professionals ==========");
        List<HealthProfessional> staffList = new ArrayList<>();

        // Three GP instances
        staffList.add(new GP(1001, "Dr Tom Wilson", List.of("Monday","Wednesday","Friday"),"East Clinic"));
        staffList.add(new GP(1002, "Dr Amy Lee", List.of("Tuesday","Thursday"),"West Clinic"));
        staffList.add(new GP(1003, "Dr Bob Brown", List.of("Monday","Tuesday"),"South Clinic"));

        // Other types
        staffList.add(new Nurse(2001, "Nurse Lily Hall", List.of("Monday","Wednesday"),"Emergency Care"));
        staffList.add(new Dietitian(3001, "Ms Zoe Moore", List.of("Tuesday","Thursday"),"Weight Management"));
        staffList.add(new Surgeon(4001, "Dr Jack Ford", List.of("Wednesday","Friday"),"Abdominal Surgery"));

        // Polymorphism: one loop print all different subclass objects
        for (HealthProfessional hp : staffList) {
            System.out.println(hp);
        }

        // ========= Part6: End‑to‑end appointment system demonstration =========
        System.out.println("\n========== Part6: Appointment System Demo ==========");
        AppointmentManager manager = new AppointmentManager();

        HealthProfessional drTom = staffList.get(0);
        HealthProfessional nurseLily = staffList.get(3);

        LocalTime t0900 = LocalTime.of(9,0);
        LocalTime t0930 = LocalTime.of(9,30);
        LocalTime t1000 = LocalTime.of(10,0);

        Appointment apt1 = new Appointment("Zhang San","0400111222", drTom, t0900);
        Appointment apt2 = new Appointment("Li Si","0400333444", nurseLily, t0930);
        Appointment apt3 = new Appointment("Wang Wu","0400555666", drTom, t1000);

        System.out.println(manager.addAppointment(apt1));
        System.out.println(manager.addAppointment(apt2));
        System.out.println(manager.addAppointment(apt3));

        // Error case 1: duplicate booking
        Appointment duplicateApt = new Appointment("Duplicate Patient","0400999999", drTom, t0900);
        System.out.println(manager.addAppointment(duplicateApt));

        System.out.println("\n--- All appointments sorted by time ---");
        for(Appointment a : manager.getAllSortedByTime()){
            System.out.println(a);
        }

        System.out.println("\n--- Filter appointments for practitioner ID 1001 ---");
        for(Appointment a : manager.filterByProfessionalId(1001)){
            System.out.println(a);
        }

        System.out.println("\n--- Filter appointments for mobile 0400333444 ---");
        for(Appointment a : manager.filterByPatientMobile("0400333444")){
            System.out.println(a);
        }

        System.out.println("\n" + manager.cancelByProfessionalAndTime(1001, t0900));
        // Error case2: cancel non‑existent appointment
        System.out.println(manager.cancelByProfessionalAndTime(9999, LocalTime.of(14,0)));

        System.out.println("\n--- Appointment list after cancellation ---");
        for(Appointment a : manager.getAllSortedByTime()){
            System.out.println(a);
        }
    }
}
