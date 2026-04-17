package ErinLeonid.StudentStream;

import java.util.Comparator;
import java.util.List;

public class StreamStudent {
    public static void processStudents(List<Student> students) {
        students.stream()
                .peek(student -> System.out.println(student))
                .map(student -> student.getBooks())
                .flatMap(book -> book.stream())
                .sorted(Comparator.comparingInt(Book::getPages)
                        .thenComparing(Book::getTitle)
                        .thenComparing(Book::getYear))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(book -> book.getYear())
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Книга найдена. Год выпуска: " + year),
                        () -> System.out.println("Такая книга отсутствует")
                );
    }
}
