package ru.lectures.Patterns.StructuralPatterns.Adapter;

public class Adapter {
    public static void main(String[] args) {
    // Преобразует интерфейс одного класса в интерфейс, ожидаемый клиентом.
        USB usb = new LightningToUSBAdapter(new LightningPort());
        usb.connect();
    }
}
