import java.util.List;

/**
 * Part1 Abstract parent class for all health professionals
 */
public abstract class HealthProfessional {
    private int id;
    private String name;
    private List<String> workDays;

    // Constructor
    public HealthProfessional(int id, String name, List<String> workDays) {
        this.id = id;
        this.name = name;
        this.workDays = workDays;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getWorkDays() {
        return workDays;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Work Days: " + workDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthProfessional that = (HealthProfessional) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
