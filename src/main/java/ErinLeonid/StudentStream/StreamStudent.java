package ErinLeonid.StudentStream;

import java.util.Comparator;
import java.util.List;

import static ErinLeonid.StudentStream.StudentConstant.LIMIT_SIZE;

public class StreamStudent {
    public static void printBookYear(List<Student> students, Integer yearFound) {

        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > yearFound)
                .limit(LIMIT_SIZE)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Книга найдена. Год выпуска: " + year),
                        () -> System.out.println("Такая книга отсутствует")
                );
    }
}
