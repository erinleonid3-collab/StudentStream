package ErinLeonid.StudentStream;


import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static ErinLeonid.StudentStream.StudentLoader.loadStudents;

public class Main {
    public static void main(String[] args) {
        List<Student> students = StudentLoader.loadStudents(Path.of("src/main/resources/Student.txt"));
        StreamStudent.processStudents(students);
    }
}