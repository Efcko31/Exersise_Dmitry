package ru.ArmyForKing.Mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ru.ArmyForKing.Armor.Armor;
import ru.ArmyForKing.DescriptionOfSolder;
import ru.ArmyForKing.Horses.Horse;
import ru.ArmyForKing.Units.Cavalry;
import ru.ArmyForKing.Units.Peasant;
import ru.ArmyForKing.Weapon.OneHandedWeapon;

@Mapper
public interface toCavalryMapper {

    toCavalryMapper INSTANCE = Mappers.getMapper(toCavalryMapper.class);

    @Mapping(target = "dateOfRequirement", expression = "java(java.time.LocalDateTime.now())", dateFormat = "dd.MM.yyyy")
    Cavalry toCavalry (Peasant peasant,
                       OneHandedWeapon weapon,
                       Armor armor
                       /*Horse horse todo решить вопрос с ошибкой*/);

    @AfterMapping
    default void setDescription(@MappingTarget Cavalry cavalry) {
        cavalry.setDescriptionOfSolder( new DescriptionOfSolder(
                cavalry.getFirstName(),
                cavalry.getLastName(),
                cavalry.getPatronymic(),
                "2-й квалерийский взвод","рядовой",
                cavalry.getWeapon().getName() + " " + cavalry.getArmor().getName() + " " /*+
                        "Боевая лошадь: " + cavalry.getWarHorse().getName()*/));
    }
}
