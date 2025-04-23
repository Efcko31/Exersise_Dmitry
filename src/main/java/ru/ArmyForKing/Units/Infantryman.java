package ru.ArmyForKing.Units;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ArmyForKing.Armor.Armor;
import ru.ArmyForKing.DescriptionOfSolder;
import ru.ArmyForKing.Weapon.OneHandedWeapon;

import java.time.LocalDateTime;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Infantryman extends Peasant {
    private OneHandedWeapon weapon;
    private Armor armor;
    private LocalDateTime dateOfRequirement; //в маппере LocalDAteTime.now() всем солдатам constanta
    private DescriptionOfSolder descriptionOfSolder; //фио + дожность + в какой роте + снаряжение @Named

}
