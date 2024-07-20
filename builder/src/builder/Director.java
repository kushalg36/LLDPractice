package builder;

public class Director {
    StudentBuilder studentBuilder;

    public Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if (studentBuilder instanceof EngStudentBuilder) {
            return createEngStudent();
        } else {
            return createMbaStudent();
        }
    }

    private Student createEngStudent() {
        return studentBuilder.setAge(20).setName("Kushal").setRollNumber(123).setSubjects().build();
    }

    private Student createMbaStudent() {
        return studentBuilder.setAge(25).setName("Anukool").setRollNumber(69).setSubjects().build();
    }
}
