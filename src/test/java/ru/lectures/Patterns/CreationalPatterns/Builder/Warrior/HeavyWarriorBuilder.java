package ru.lectures.Patterns.CreationalPatterns.Builder.Warrior;

public class HeavyWarriorBuilder implements WarriorBuilder {
    private final Warrior heavyWarrior = new Warrior();
    @Override
    public void buildHelmet() {
        heavyWarrior.setHelmet("Латный шлем");
    }

    @Override
    public void buildArmor() {
        heavyWarrior.setArmor("Латный нагрудник");
    }

    @Override
    public void buildBraces() {
        heavyWarrior.setBracer("Латные наручи");
    }

    @Override
    public void buildLeg() {
        heavyWarrior.setLeg("Латные ботинки");
    }

    @Override
    public void buildLeftHand() {
        heavyWarrior.setLeftHand("Двуручный стальной меч");
    }

    @Override
    public void buildRightHand() {
        heavyWarrior.setRightHand("Двуручный стальной меч");
    }

    @Override
    public Warrior getResult() {
        return heavyWarrior;
    }
}
