package ru.Oop.Phone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneCorrectV1 {
    private String number;
    private String model;
    private int weight;


    public void receiveCall(String name) {
        System.out.println("\nЗвонит: " + name);
    }

    public void receiveCall(String name, String number) {
        System.out.println("\nЗвонит: " + name + "\n" + number);
    }

    public void receiveCall(String name, int number) {
        System.out.println("\nЗвонит: " + name + "\n" + number);
    }

    public void sendMassage(String... number) {
        System.out.println("\nСообщение получат:\n");
        for (String i : number) {
            System.out.println(i);
        };
    }

    public void printInformationAboutPhone() {
        System.out.printf(" model: %s \n" +
                "number: %s \n" +
                "weight: %d%n \n", model, number, weight);
    }
}
