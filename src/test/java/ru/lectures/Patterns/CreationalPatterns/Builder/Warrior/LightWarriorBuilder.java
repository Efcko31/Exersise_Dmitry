package ru.lectures.Patterns.CreationalPatterns.Builder.Warrior;

public class LightWarriorBuilder implements WarriorBuilder {
    private final Warrior lightWarrior = new Warrior();
    @Override
    public void buildHelmet() {
        lightWarrior.setHelmet("Кожаный шлем");
    }

    @Override
    public void buildArmor() {
        lightWarrior.setArmor("Кожаный нагрудник");
    }

    @Override
    public void buildBraces() {
        lightWarrior.setBracer("Кожаные наручи");
    }

    @Override
    public void buildLeg() {
        lightWarrior.setLeg("Кожаный ботинки");
    }

    @Override
    public void buildLeftHand() {
        lightWarrior.setLeftHand("Железный меч");
    }

    @Override
    public void buildRightHand() {
        lightWarrior.setRightHand("Железный щит");
    }

    @Override
    public Warrior getResult() {
        return lightWarrior;
    }
}
