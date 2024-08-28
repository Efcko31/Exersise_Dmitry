package ru.Oop.LibraryOop;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReaderTest {
    ArrayList<Reader> readerArray = new ArrayList<>();

    Reader person1 = new Reader("Иванов А.А.",
                                1L,
                                "Менеджмент",
                                LocalDate.of(2000,4,13),
                                "8-800-555-35-35");
    Reader person2 = new Reader("Петрова А.И.",
                                2L,
                                "Философия",
            LocalDate.of(2002,5,12),
                                "8-999-555-66-11");

    Book book1 = new Book("А.С.Пушкин", "Капитанская дочка");
    Book book2 = new Book("А.П.Чехов", "Толстый и тонкий");
    Book book3 = new Book("Л.Н.Толстой", "Война и мир. Том 1");
    Book book4 = new Book("С.А.Есенин", "Письмо к женщине");
    Book book5 = new Book("Даниэль Дефо", "Робинзон Крузо");

    @Test
    public void testReader() {
        ReaderUtil.addStudentToTheReadingList(readerArray, person1, person2);
        readerArray.get(0).takeBook(2);
        readerArray.get(0).returnBook(1);

        readerArray.get(1).takeBook(book1, book4);
        readerArray.get(1).takeBook(book1.getBookName());
        readerArray.get(1).returnBook(book1, book3);
        readerArray.get(1).takeBook(book5.getBookName());

        readerArray.get(0).returnBook(book2.getBookName());

        System.out.println(person1.toString());

    }
}
