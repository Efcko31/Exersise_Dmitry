package ru.lectures.Patterns.BehavioralPatterns.Command;

public class Test {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        remote.setCommand(new LightOnCommand(new Light()));
        remote.pressButton(); // Свет включён

//      + Разделяет отправителя и получателя команды.
//      - Много классов для простых операций.
    }
}
