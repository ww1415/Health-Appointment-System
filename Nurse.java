import java.util.List;

/**
 * Part2: Nurse subclass
 */
public class Nurse extends HealthProfessional {
    private String nursingSpecialty;

    public Nurse(int id, String name, List<String> workDays, String nursingSpecialty) {
        super(id, name, workDays);
        this.nursingSpecialty = nursingSpecialty;
    }

    @Override
    public String toString() {
        return "Nurse | " + super.toString() + ", Specialty: " + nursingSpecialty;
    }
}
