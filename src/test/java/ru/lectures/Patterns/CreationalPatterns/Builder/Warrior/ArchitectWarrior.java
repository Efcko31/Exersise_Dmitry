package ru.lectures.Patterns.CreationalPatterns.Builder.Warrior;

public class ArchitectWarrior {
    private WarriorBuilder builder;

    public ArchitectWarrior(WarriorBuilder builder) {
        this.builder = builder;
    }

    public Warrior construct() {
        builder.buildHelmet();
        builder.buildArmor();
        builder.buildBraces();
        builder.buildLeg();
        builder.buildLeftHand();
        builder.buildRightHand();
        return builder.getResult();
    }
}
