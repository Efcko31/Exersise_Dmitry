package ru.Oop.company.details;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Engine {

    protected int power;
    protected String manufacturer;

    public String toString() {
    return  String.format("Двигатель:\nмощность: %d л.с.\nпроизводитель: %s\n", power, manufacturer);}
}
