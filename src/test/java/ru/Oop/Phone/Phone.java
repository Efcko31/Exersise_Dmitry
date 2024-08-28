package ru.Oop.Phone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    private String number;
    private String model;
    private Integer weight;

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public void receiveCall(String name) {
        System.out.println("\nЗвонит: " + name);
    }
    public void receiveCall(String name, String number) {
        System.out.println("\nЗвонит: " + name + "\n" + number);
    }
    public void sendMassage(String... number) {
        System.out.println("\nСообщение получат:\n");
        for (String i : number) {
            System.out.println(i);
        }
    }
    public void allInformationOfPhone() {
        System.out.printf(" model: %s \n" +
                "number: %s \n" +
                "weight: %d%n", model, number, weight);
    }
}