import java.util.List;

/**
 * Part2: Surgeon subclass
 */
public class Surgeon extends HealthProfessional {
    private String surgeryType;

    public Surgeon(int id, String name, List<String> workDays, String surgeryType) {
        super(id, name, workDays);
        this.surgeryType = surgeryType;
    }

    @Override
    public String toString() {
        return "Surgeon | " + super.toString() + ", Surgery Type: " + surgeryType;
    }
}
