package ru.ArmyForKing.Mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ru.ArmyForKing.Armor.Armor;
import ru.ArmyForKing.DescriptionOfSolder;
import ru.ArmyForKing.Units.Archer;
import ru.ArmyForKing.Units.Cavalry;
import ru.ArmyForKing.Units.Peasant;
import ru.ArmyForKing.Weapon.TwoHandedWeapons;

@Mapper
public interface toArcherMapper {

    toArcherMapper INSTANCE = Mappers.getMapper(toArcherMapper.class);

    @Mapping(target = "dateOfRequirement", expression = "java(java.time.LocalDateTime.now())", dateFormat = "dd.MM.yyyy")
    Archer toArcher (Peasant peasant,
                     TwoHandedWeapons weapon,
                     Armor armor);

    @AfterMapping
    default void setDescription(@MappingTarget Archer archer) {
        archer.setDescriptionOfSolder( new DescriptionOfSolder(
                archer.getFirstName(),
                archer.getLastName(),
                archer.getPatronymic(),
                "1-й взвод",
                "Рядовой",
                archer.getWeapon().getName() + " " + archer.getArmor().getName()));
    }

}
