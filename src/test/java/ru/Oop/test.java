package ru.Oop;

public class test {


    public static void main(String[] args) {
        String firstName = "Бабуин    ";
        if (firstName.matches("[а-яА-Яa-zA-Z\\-\\s]+")) {
            System.out.println("LF");
        } else {
            System.out.println("Имя введено некорректно!");

        }
    }
}