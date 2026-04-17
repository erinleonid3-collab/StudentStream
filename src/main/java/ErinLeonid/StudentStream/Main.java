package ErinLeonid.StudentStream;

import java.nio.file.Path;
import java.util.List;

import static ErinLeonid.StudentStream.StudentConstant.STUDENT_FILE_PATH;
import static ErinLeonid.StudentStream.StudentConstant.YEAR_FOUND;


public class Main {
    public static void main(String[] args) {
        List<Student> students = StudentLoader.loadStudents(STUDENT_FILE_PATH);
        StreamStudent.printBookYear(students, YEAR_FOUND);
    }
}