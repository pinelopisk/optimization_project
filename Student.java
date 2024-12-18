import java.util.List;

public class Student {
    private String name;
    private int am;
    private List<Integer> answers; // Δυναμική λίστα απαντήσεων

    // Constructor
    public Student(String name, int am, List<Integer> answers) {
        this.name = name;
        this.am = am;
        this.answers = answers;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAm() {
        return am;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", am=" + am +
                ", answers=" + answers +
                '}';
    }
}
