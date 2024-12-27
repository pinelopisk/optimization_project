import java.util.List;

public class Student {
    private String name;
    private String surname;
    private String am;
    private List<Integer> answers;

    public Student(String name, String surname, String am, List<Integer> answers) {
        this.name = name;
        this.surname = surname;
        this.am = am;
        this.answers = answers;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAm() {
        return am;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", am='" + am + '\'' +
                ", answers=" + answers +
                '}';
    }
}
