package ru.ArmyForKing.Horses;

import lombok.Getter;

import java.util.List;
import static ru.ArmyForKing.Utils.Constants.FEMALE_GENDER;
import static ru.ArmyForKing.Utils.Constants.MALE_GENDER;

@Getter
public enum AllHorses {

     SIVKA(new Horse("Сивка", FEMALE_GENDER, 6)),
     LORIC(new Horse("Лорик", MALE_GENDER, 8)),
     BURKA(new Horse("Бурка", FEMALE_GENDER, 5)),
     BORIS(new Horse("Борис", MALE_GENDER, 9)),
     GUNGNIR(new Horse("Гунгнир", FEMALE_GENDER, 11));
    private final Horse horse;

    AllHorses(Horse horse) {this.horse = horse; }
    public static final List<AllHorses> HORSE_STALL = List.of(SIVKA, LORIC, BORIS, BURKA, GUNGNIR);

}
