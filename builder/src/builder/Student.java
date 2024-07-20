package builder;

import java.util.Arrays;
import java.util.List;

public class Student {
    int rollNum;
    int age;
    String name;
    List<String> subjects;

    public Student(StudentBuilder studentBuilder) {
        this.rollNum = studentBuilder.rollNum;
        this.age = studentBuilder.age;
        this.name = studentBuilder.name;
        this.subjects = studentBuilder.subjects;
    }

    @Override
    public String toString() {
        return "age: " + this.age + ", roll: " + this.rollNum + ", name: " + this.age + ", subjects: " + subjects;
    }
}
