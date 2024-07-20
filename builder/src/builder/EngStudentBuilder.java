package builder;

import java.util.ArrayList;
import java.util.List;

public class EngStudentBuilder extends StudentBuilder {

    @Override
    public StudentBuilder setSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("DSA");
        subjects.add("Mech");
        subjects.add("OS");
        this.subjects = subjects;
        return this;
    }
}
