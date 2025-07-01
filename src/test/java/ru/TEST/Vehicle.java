package ru.TEST;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private int km;
    public static void printNameVehicle(int km) {
        System.out.println("Механизм" + km);
    }
}
