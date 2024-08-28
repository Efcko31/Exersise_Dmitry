package ru.Oop.Time;

public class Time {

    //свойства класса
    int hour;
    int minutes;
    int seconds;

    //конструктор класса
    public Time() {
        this.hour = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public Time(int hour, int minutes, int seconds) {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    //методы класса
    void plusHour() {
        hour++;
    }

    void plusHour(int n) {
        hour++;
    }

    void printTime() {
        System.out.format("%d:%d:%d%n", this.hour, this.minutes, this.seconds);
    }
}
