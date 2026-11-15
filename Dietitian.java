import java.util.List;

/**
 * Part2: Dietitian subclass
 */
public class Dietitian extends HealthProfessional {
    private String focusArea;

    public Dietitian(int id, String name, List<String> workDays, String focusArea) {
        super(id, name, workDays);
        this.focusArea = focusArea;
    }

    @Override
    public String toString() {
        return "Dietitian | " + super.toString() + ", Focus Area: " + focusArea;
    }
}
