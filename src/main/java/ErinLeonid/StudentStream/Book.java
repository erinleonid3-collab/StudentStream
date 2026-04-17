package ErinLeonid.StudentStream;

import java.util.Objects;

public class Book {
    private final String title;
    private final int yearOfPublication;
    private final int pageCount;

    public Book(String title, int yearOfPublication, int pageCount) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return yearOfPublication;
    }

    public int getPages() {
        return pageCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return yearOfPublication == book.yearOfPublication && pageCount == book.pageCount && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, yearOfPublication, pageCount);
    }


    @Override
    public String toString() {
        return String.format("Book{название='%s', год=%d, стр=%d}", title, yearOfPublication, pageCount);
    }
}
