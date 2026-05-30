package ru.Oop.WorkSchedule;

import org.junit.jupiter.api.Test;

import static ru.Oop.WorkSchedule.DayOfWeek.*;

public class WorkSchedule {

    @Test
    void test() {
        workSchedule(SUNDAY);
        workSchedule(FRIDAY);
        workSchedule(TUESDAY);
        workSchedule(SATURDAY);
    }

    public void workSchedule(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case SUNDAY, SATURDAY:
                System.out.println("Магазин не работает.");
                break;
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY:
                System.out.println("Магазин работает с 10:00 до 20:00.");
        }
    }
}
