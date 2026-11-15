import java.util.List;

/**
 * Part2: General Practitioner subclass
 */
public class GP extends HealthProfessional {
    private String communityClinic;

    public GP(int id, String name, List<String> workDays, String communityClinic) {
        super(id, name, workDays);
        this.communityClinic = communityClinic;
    }

    @Override
    public String toString() {
        return "General Practitioner | " + super.toString() + ", Community Clinic: " + communityClinic;
    }
}
