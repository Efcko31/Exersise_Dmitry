package ru.ArmyForKing.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ru.ArmyForKing.Armor.Armor;
import ru.ArmyForKing.Units.Cavalry;
import ru.ArmyForKing.Units.Peasant;
import ru.ArmyForKing.Weapon.OneHandedWeapon;

@Mapper
public interface toCavalryMapper {

    toCavalryMapper INSTANCE = Mappers.getMapper(toCavalryMapper.class);

    @Mapping(target = "dateOfRequirement", expression = "java(java.time.LocalDateTime.now())", dateFormat = "dd.MM.yyyy")
    Cavalry toCavalry (Peasant peasant,
                       OneHandedWeapon weapon,
                       Armor armor);
}
