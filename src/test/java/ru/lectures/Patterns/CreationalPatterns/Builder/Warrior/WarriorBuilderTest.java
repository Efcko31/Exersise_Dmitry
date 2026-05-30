package ru.lectures.Patterns.CreationalPatterns.Builder.Warrior;

public class WarriorBuilderTest {
    public static void main(String[] args) {
        WarriorBuilder lightWarriorBuilder = new LightWarriorBuilder();
        ArchitectWarrior lightArchitectWarrior = new ArchitectWarrior(lightWarriorBuilder);
        Warrior lightWarrior = lightArchitectWarrior.construct();
        System.out.println(lightWarrior.toString());

        WarriorBuilder heavyWarriorBuilder = new HeavyWarriorBuilder();
        ArchitectWarrior heavyArchitectWarrior = new ArchitectWarrior(heavyWarriorBuilder);
        Warrior heavyWarrior = heavyArchitectWarrior.construct();
        System.out.println(heavyWarrior.toString());
    }
}
