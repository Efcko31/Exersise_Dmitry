package ru.ArmyForKing.Mappers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.ArmyForKing.Armor.Armor;
import ru.ArmyForKing.DescriptionOfSolder;
import ru.ArmyForKing.Units.Infantryman;
import ru.ArmyForKing.Units.Peasant;
import ru.ArmyForKing.Weapon.OneHandedWeapon;

import java.time.LocalDateTime;


@Mapper(imports = LocalDateTime.class )
public interface toInfantrymanMapper {
    toInfantrymanMapper INSTANCE = Mappers.getMapper(toInfantrymanMapper.class);

    @Mapping(target = "dateOfRequirement", expression = "java(LocalDateTime.now())", dateFormat = "dd.MM.yyyy")
    Infantryman toInfantryman(Peasant peasant,
                              OneHandedWeapon weapon,
                              Armor armor);

    @AfterMapping
    default void setDescription(@MappingTarget Infantryman infantryman) {
        infantryman.setDescriptionOfSolder( new DescriptionOfSolder(
                infantryman.getFirstName(),
                infantryman.getLastName(),
                infantryman.getPatronymic(),
                "1-й взвод",
                "Рядовой",
                infantryman.getWeapon().getName() + " " + infantryman.getArmor().getName()));
    }

}
