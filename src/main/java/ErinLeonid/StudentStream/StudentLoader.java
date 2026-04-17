package ErinLeonid.StudentStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StudentLoader {


    public static List<Student> loadStudents(Path filePath) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) continue;
                try {
                    if (parseStudent(line).getBooks().size() < 5) continue;
                    students.add(parseStudent(line));

                } catch (Exception e) {
                    System.err.println("Ошибка добавления строки: " + line);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("Не удалось прочитать файл: " + filePath);
            e.printStackTrace();
        }
        return students;
    }

    private static Student parseStudent(String line) {

        List<Book> bookList = new ArrayList<>();
        String[] lineArray = line.trim().split("\\|", -1);
        String name = lineArray[0].trim();

        for (int i = 1; i < lineArray.length; i++) {

            String[] bookData = lineArray[i].trim().split(";", -1);
            if (bookData.length != 3) {
                continue;
            }
            try {
                String title = bookData[0].trim();
                int year = Integer.parseInt(bookData[1]);
                int pages = Integer.parseInt(bookData[2]);
                if (title.isEmpty() || year < 0 || pages <= 0) continue;
                bookList.add(new Book(title, year, pages));
            } catch (NumberFormatException e) {
                System.err.println("Неккоректный формат чисел, пропущенна книга: " + bookData[0]);
            }
        }

        return new Student(name, bookList);

    }
}
