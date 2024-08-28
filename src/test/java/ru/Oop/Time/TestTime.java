package ru.Oop.Time;

import org.junit.jupiter.api.Test;

public class TestTime {

    @Test
    void whatTimeTestT() {
        Time time = new Time();
        time.printTime();

        time.plusHour();
        time.printTime();

        time.plusHour(5);
        time.printTime();

        time = new Time(15, 23, 57);
        time.printTime();

        time.plusHour();
        Time time1 = new Time();

    }
}
