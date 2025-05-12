package ru.lectures.Patterns.StructuralPatterns.Facade;

public class ComputerFacade {
    private CPU cpu;
    private Memory memory;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
    }

    void start() {
        cpu.start();
        memory.load();
    }
}
