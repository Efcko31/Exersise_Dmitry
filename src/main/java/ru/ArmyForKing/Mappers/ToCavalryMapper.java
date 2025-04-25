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
public interface ToCavalryMapper {

    ToCavalryMapper INSTANCE = Mappers.getMapper(ToCavalryMapper.class);

    @Mapping(target = "dateOfRequirement", expression = "java(java.time.LocalDateTime.now())", dateFormat = "dd.MM.yyyy")
    @Mapping(target = "age", source = "peasant.age")
    @Mapping(target = "gender", source = "peasant.gender")
    @Mapping(source = "horse", target = "warHorse")
    Cavalry toCavalry(Peasant peasant,
                      OneHandedWeapon weapon,
                      Armor armor,
                      Horse horse);

    @AfterMapping
    default void setDescription(@MappingTarget Cavalry cavalry) {
        cavalry.setDescriptionOfSolder(new DescriptionOfSolder(
                cavalry.getFirstName(),
                cavalry.getLastName(),
                cavalry.getPatronymic(),
                "2-й квалерийский взвод", "рядовой",
                cavalry.getWeapon().getName() + " " + cavalry.getArmor().getName() + " " +
                        "Боевая лошадь: " + cavalry.getWarHorse().getName()));
    }
}
