package ru.Oop.company.vehicles;

import ru.Oop.company.details.Engine;
import ru.Oop.company.professions.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car { //extent Object
    protected String brand;
    protected String classCar;
    protected Integer weight;
    protected Driver driver;
    protected Engine engine;

    public void start() {
        System.out.println("Поехали");
    }

    public void stop() {
        System.out.println("Останавливаемся");
    }

    public void turnRight() {
        System.out.println("Поворот направо");
    }

    public void turnLeft() {
        System.out.println("Поворот налево");
    }
    @Override
    public String toString() {
        return String.format("Автомобиль: %s\nКласс: %s\nВес: %d\n Водитель: \n%s\n %s",
                brand, classCar, weight, driver.toString(), engine.toString());}

}
