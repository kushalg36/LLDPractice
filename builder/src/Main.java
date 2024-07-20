import builder.Director;
import builder.EngStudentBuilder;
import builder.MbaStudent;
import builder.Student;

public class Main {
    public static void main(String[] args) {
        Director director1 = new Director(new EngStudentBuilder());
        Director director2 = new Director(new MbaStudent());

        Student engStudent = director1.createStudent();
        Student mbaStudent = director2.createStudent();

        System.out.println(engStudent);
        System.out.println(mbaStudent);
    }
}