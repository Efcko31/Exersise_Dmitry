package ru.Base64Excersises;

import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.Scanner;

public class ExLvl1 {
    //Напишите программу, которая кодирует ваше имя в Base64 и выводит результат.
    @Test
    void encodesTheNameTest() {
        encodesTheName("Илья");

    }

    public void encodesTheName(String myName) {
        String encoded = Base64.getEncoder().encodeToString(myName.getBytes());
        System.out.println("Закодировано: " + encoded);

        byte[] decodedByte = Base64.getDecoder().decode(encoded);
        String decoded = new String(decodedByte);
        System.out.println("Раскодировано: " + decoded);
    }

    //Напишите программу, которая принимает строку от пользователя, кодирует ее в Base64, а затем декодирует обратно.
    @Test
    void acceptsAStringFromTheUserEncodesItTest() {
        acceptsAStringFromTheUserEncodesIt(new Scanner(System.in).nextLine());
    }

    public void acceptsAStringFromTheUserEncodesIt(String sentence) {
        String encodedUsersSentence = Base64.getEncoder().encodeToString(sentence.getBytes());
        System.out.println("Закодировано: " + encodedUsersSentence);

        byte[] decodedByte = Base64.getDecoder().decode(encodedUsersSentence);
        String decodedSentence = new String(decodedByte);
        System.out.println("Раскодировано: " + decodedSentence);

    }

    //Создайте метод, который сравнивает длину исходной строки и ее Base64 представления.
    @Test
    void comparesTheLengthOfAStringAndItsBase64EncodedVersionTest() {
        comparesTheLengthOfAStringAndItsBase64EncodedVersion("Base64 - схема кодирования, " +
                "которая позволяет перевести двоичные данные в строку формата ASCII и наоборот.");
    }

    public void comparesTheLengthOfAStringAndItsBase64EncodedVersion(String sentence) {
        String encoded = Base64.getEncoder().encodeToString(sentence.getBytes());
        System.out.println("Длина исходной строки: " + sentence.length() +
                "\n" + "Длина закодированной строки: " + encoded.length());
    }
}
