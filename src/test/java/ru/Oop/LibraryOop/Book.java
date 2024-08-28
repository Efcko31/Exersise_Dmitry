package ru.Oop.LibraryOop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private  String authorName;
    private String bookName;

    @Override
    public String toString() {
        return authorName + " " + bookName;
    }
}
