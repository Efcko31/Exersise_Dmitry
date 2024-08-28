package ru.Oop.LibraryOop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reader {

    private String fullName;
    private Long numberLibraryCard;
    private String nameFaculty;
    private LocalDate dateOfBirth;
    private String telephoneNumber;

    @Override
    public String toString() {
        return String.format("Имя: %s;\nНомер билета: %d;\nФакультет: %s;\nДата рождения: " + dateOfBirth + ";\nНомер телеона: %s.",
                fullName, numberLibraryCard, nameFaculty, telephoneNumber);
    }

    public void takeBook(int numberBooks) {
        if (numberBooks == 1) {
            System.out.println(fullName + " взял(а) " + numberBooks + " книгу.\n");
        } else if (numberBooks > 1 & numberBooks < 5) {
            System.out.println(fullName + " взял(а) " + numberBooks + " книги.\n");
        } else if ( numberBooks > 4) {
            System.out.println(fullName + " взял(а) " + numberBooks + " книг.\n");
        } else {
            System.out.println("Количество книг должно быть больше 0!");
        }
    }

    public void takeBook(String... nameBook) {
        if (nameBook.length == 1) {
            System.out.println(fullName + " взял(а) книгу: " + nameBook[0] + "\n");
        } else if (nameBook.length > 1) {
            System.out.print(fullName + " взял(а) книги: ");
            for (int i = 0; i < nameBook.length; i++) {
                System.out.print(nameBook[i] + (i + 1 == nameBook.length ? ".\n" : ", "));
            }
        }
    }

    public void takeBook(Book... book) {
        if (book.length == 1) {
            System.out.println(fullName + " взял(а) книгу: " + book[0].toString() + "\n");
        } else if (book.length > 1) {
            System.out.print(fullName + " взял(а) книги: ");
            for (int i = 0; i < book.length; i++) {
                System.out.print(book[i].toString() + (i + 1 == book.length ? ".\n" : ", "));
            }
        }
    }

    public void returnBook(int numberBooks) {
        if (numberBooks == 1) {
            System.out.println(fullName + " вернул(а) " + numberBooks + " книгу.\n");
        } else if (numberBooks > 1 & numberBooks < 5) {
            System.out.println(fullName + " вернул(а) " + numberBooks + " книги.\n");
        } else if ( numberBooks > 4) {
            System.out.println(fullName + " вернул(а) " + numberBooks + " книг.\n");
        } else {
            System.out.println("Количество книг должно быть больше 0!");
        }
    }

    public void returnBook(String... nameBook) {
        if (nameBook.length == 1) {
            System.out.println(fullName + " вернул(а) книгу: " + nameBook[0] + "\n");
        } else if (nameBook.length > 1) {
            System.out.print(fullName + " вернул(а) книги: ");
            for (int i = 0; i < nameBook.length; i++) {
                System.out.print(nameBook[i] + (i + 1 == nameBook.length ? ".\n" : ", "));
            }
        }
    }

    public void returnBook(Book... book) {
        if (book.length == 1) {
            System.out.println(fullName + " вернул(а) книгу: " + book[0].toString() + "\n");
        } else if (book.length > 1) {
            System.out.print(fullName + " вернул(а) книги: ");
            for (int i = 0; i < book.length; i++) {
                System.out.print(book[i].toString() + (i + 1 == book.length ? ".\n" : ", "));
            }
        }
    }
}
