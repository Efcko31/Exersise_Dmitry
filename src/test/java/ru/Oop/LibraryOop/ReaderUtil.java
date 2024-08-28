package ru.Oop.LibraryOop;

import java.util.ArrayList;
import java.util.Arrays;

public class ReaderUtil {
    public static void addStudentToTheReadingList(ArrayList<Reader> readerArray, Reader... person) {
        readerArray.addAll(Arrays.asList(person));
    }
}