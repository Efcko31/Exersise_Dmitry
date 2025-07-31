package ru.lectures.Patterns.CreationalPatterns.Builder.Warrior;

interface WarriorBuilder {
    void buildHelmet();

    void buildArmor();

    void buildBraces();

    void buildLeg();

    void buildLeftHand();

    void buildRightHand();

    Warrior getResult();

}
