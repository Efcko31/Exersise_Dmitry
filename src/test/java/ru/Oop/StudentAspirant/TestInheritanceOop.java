package ru.Oop.StudentAspirant;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestInheritanceOop {
    ArrayList<Student> faculty1Group1 = new ArrayList<>();
    Student student1 = new Student(
            "Стас",
            "Петров",
            "Менеджмент",
            5.0);
    Student student2 = new Student(
            "Дмитрий",
            "Николаев",
            "Менеджмент",
            3.9);
    Student student3 = new Student(
            "Габриэл",
            "Петров",
            "Менеджмент",
            4.9);
    Aspirant aspirant1 = new Aspirant(
            "СтЭпан",
            "Петров",
            "Менеджмент",
            null,
            "Прокладывание");
    Aspirant aspirant2 = new Aspirant(
            "Андей",
            "Петров",
            "Менеджмент",
            4.9,
            "Закладывание");
    Aspirant aspirant3 = new Aspirant(
            "Иван",
            "Петров",
            "Менеджмент",
            5.0,
            "Вкладывание");

    @Test
    public void testStudentAndAspirant() {
        StudentsUtil.addStudentsToAGroup(faculty1Group1, student1, student2, student3, aspirant1, aspirant2, aspirant3);

        for (Student student : faculty1Group1) {
            System.out.printf("%s %s, Ваша стипендия равна %d руб.\n",
                    student.getFirstName(), student.getLastName(), student.getScholarship());
        }
    }
}