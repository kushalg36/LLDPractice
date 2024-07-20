package builder;

import java.util.List;

public abstract class StudentBuilder {
    int rollNum;
    int age;
    String name;
    List<String> subjects;

    public StudentBuilder setRollNumber(int rollNumber) {
        this.rollNum = rollNumber;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    abstract public StudentBuilder setSubjects();

    public Student build() {
        return new Student(this);
    }

}
