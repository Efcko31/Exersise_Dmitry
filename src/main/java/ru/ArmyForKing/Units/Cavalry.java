package ru.ArmyForKing.Units;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.ArmyForKing.Armor.Armor;
import ru.ArmyForKing.DescriptionOfSolder;
import ru.ArmyForKing.Horses.Horse;
import ru.ArmyForKing.Weapon.OneHandedWeapon;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true) //todo ?????
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cavalry extends Peasant {
    private OneHandedWeapon weapon;
    private Armor armor;
    private Horse warHorse;
    private LocalDateTime dateOfRequirement; //в маппере LocalDAteTime.now() всем солдатам constanta
    private DescriptionOfSolder descriptionOfSolder; //фио + дожность + в какой роте + снаряжение @Named
}
