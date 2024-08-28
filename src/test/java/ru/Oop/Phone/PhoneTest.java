package ru.Oop.Phone;

import org.junit.jupiter.api.Test;

public class PhoneTest {

    Phone nokia = new Phone("8-999-222-55-66", " Nokia 1100", 93);
    Phone motorola = new Phone("8-800-555-35-35", " Motorola KRZR K1", 102);
    Phone sonyEricsson = new Phone("8-999-222-44-15", " SonyEricsson T700", 78);

    Phone chinaSuperMobile = new Phone("+4-3000-56-222", "hara_Kiri 3023", 2000);

    @Test
    public void testPhone() {
        System.out.println(PhoneUtil.checkPhoneNumberIsCorrect(chinaSuperMobile.getNumber()));
        System.out.println(PhoneUtil.checkingWeightIndication(chinaSuperMobile.getWeight()) + "\n");

        nokia.allInformationOfPhone();
        motorola.allInformationOfPhone();
        sonyEricsson.allInformationOfPhone();

        nokia.receiveCall("Илья");
        nokia.receiveCall("Илья", "8-999-888-55-66");
        nokia.sendMassage("999", "888", "777");

        motorola.receiveCall("Лина");
        motorola.receiveCall("Илья", "8-999-888-55-66");
        motorola.sendMassage("8-990-999-99-99", "8-888-888-88-88", "+7-777-777-77-77");

        sonyEricsson.receiveCall("Вэйдер");
        sonyEricsson.receiveCall("Илья", "8-999-888-55-66");
        sonyEricsson.sendMassage("0000", "1111", "22222");
    }
}