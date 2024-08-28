package ru.Oop.StudentAspirant;

import java.util.ArrayList;

public class StudentsUtil {
    public static void addStudentsToAGroup(ArrayList<Student> group, Student... students) {
        for (Student student : students) {
            if (group.size() == 20) {
                System.out.println("В группе не может быть более 20 человек!");
            } else {
                group.add(student);
            }
        }
    }
}
