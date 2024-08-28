package ru.Oop.company;

public class CarUtil {

    public static boolean checkFullNameCorrect(Person person) {
        if (checkFirstNameCorrect(person.getFirstName()) &
                checkLastNameCorrect(person.getLastName()) &
                checkPatronymicCorrect(person.getPatronymic()) &
                checkAgeCorrect(person.getAge())) {
            System.out.println("Все данные корректны.");
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkFirstNameCorrect(String firstName) {
        if (firstName.matches("[а-яА-Яa-zA-Z\\-\\s]+")) {
            return true;
        } else {
            System.out.println("Имя введено некорректно!");
            return false;
        }
    }

    public static boolean checkLastNameCorrect(String lastName) {
        if (lastName.matches("[а-яА-Яa-zA-Z\\-\\s]+")) {
            return true;
        } else {
            System.out.println("Фамилия введена некорректно! ");
            return false;
        }
    }

    public static boolean checkPatronymicCorrect(String patronymic) {
        if (patronymic.matches("[а-яА-Яa-zA-Z\\-\\s]+")) {
            return true;
        } else {
            System.out.println("Отчетсво введено некорректно!");
            return false;
        }
    }

    public static boolean checkAgeCorrect(Integer age) {
        if( age > 18 && age < 90) {
            return true;
        } else {
            System.out.println("Возраст должен быть от 18 до 90 лет");
            return false;
        }
    }
}
