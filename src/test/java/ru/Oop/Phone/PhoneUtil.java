package ru.Oop.Phone;

public class PhoneUtil {

    public static boolean checkPhoneNumberIsCorrect(String number) {
        String regex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        if (number.matches(regex)) {
            return true;
        } else {
            System.out.println("Ошибка! Неверный формат номера телефона!");
            return false;
        }
    }

    public static boolean checkingWeightIndication(Integer weight) {
        if(weight < 1000) {
            return true;
        } else {
            System.out.println("Ошибка! Вес мобильного телефона не может быть более 1000 грамм!");
            return false;
        }
    }


}
