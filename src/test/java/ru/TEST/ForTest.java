package ru.TEST;

import org.junit.jupiter.api.Test;

public class ForTest {
    @Test
    void test() {
        classTest();
    }
    public void classTest() {
        Vehicle car1 = new Car(10);
        Car car2 = new Car(15);
        car1.printNameVehicle(10);
        car2.printNameVehicle(15);
    }

}

