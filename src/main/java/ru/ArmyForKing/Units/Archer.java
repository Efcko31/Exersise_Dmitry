package ru.ArmyForKing.Units;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ArmyForKing.Armor.Armor;
import ru.ArmyForKing.DescriptionOfSolder;
import ru.ArmyForKing.Weapon.TwoHandedWeapons;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Archer extends Peasant {
    private TwoHandedWeapons weapon;
    private Armor armor;
    private LocalDateTime dateOfRequirement; //в маппере LocalDAteTime.now() всем солдатам constanta
    private DescriptionOfSolder descriptionOfSolder; //фио + дожность + в какой роте + снаряжение @Named

}

