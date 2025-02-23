package ru.Oop.AnArmyForTheKing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static ru.Oop.AnArmyForTheKing.AllPeasant.*;

public class RecruitmentTheKingsArmy {

    @Test
    void test() {
        /*"Пехота: Иванов Сидоров Задорнов Вавилов ; Лучники: Гагус Вагин Стрельчонок "*/
        assertEquals(List.of(), recruitsInfantryIntoArmy());
        assertTrue(equalsAll(List.of(antonIvanov, ivanSidorov, mikhailZadornov, nikolayVavilov),
                recruitsInfantryIntoArmy(antonIvanov, peterCheshkov, artemShtilko, irinaGalgadot, ivanSidorov, olegGagus, dmitryVagin,
                mikhailZadornov, maksimStrelchonok, nikolayVavilov)));

        assertTrue(equalsAll(List.of(olegGagus, dmitryVagin, maksimStrelchonok),
                recruitsArcherIntoArmy(antonIvanov, peterCheshkov, artemShtilko, irinaGalgadot, ivanSidorov, olegGagus, dmitryVagin,
                        mikhailZadornov, maksimStrelchonok, nikolayVavilov)));
        assertEquals(List.of(), recruitsArcherIntoArmy());
    }

    public List<Peasant> recruitsInfantryIntoArmy(Peasant... peasants) {//Верни армию а не строку
        if (peasants.length > 0) {
            return Arrays.stream(peasants).toList().stream().
                    filter(i -> "М".equals(i.getGender()) && i.getAge() < 60 && i.getHealthAssessment() > 65).
                    map(i -> new Infantryman(
                            i.getFirstName(),
                            i.getLastName(),
                            i.getPatronymic(),
                            i.getGender(),
                            i.getAge(),
                            i.getHealthAssessment(),
                            i.getDescription(),
                            "Железный меч",
                            "Кольчуга шлем пластины на запястье")).
                    collect(Collectors.toList());
//            StringBuilder answer = new StringBuilder();
//            answer.append("Пехота: ");
//            Infantry1stPlatoon.forEach(i -> answer.append(i.getLastName() + " "));
        } else {
            System.out.println("Не может быть, что-бы совсем никого не было! Отправить отряд для проверки в деревни!");
            return Collections.emptyList();
        }
    }//todo Collectors

    public List<Peasant> recruitsArcherIntoArmy(Peasant... peasants) {
        if (peasants.length > 0) {
            return Arrays.stream(peasants).toList().stream().
                    filter(i -> "М".equals(i.getGender()) &&
                            i.getAge() < 60 &&
                            i.getHealthAssessment() > 50 &&
                            i.getHealthAssessment() < 66).
                    map(i -> new Archer(
                            i.getFirstName(),
                            i.getLastName(),
                            i.getPatronymic(),
                            i.getGender(),
                            i.getAge(),
                            i.getHealthAssessment(),
                            i.getDescription(), "Длинный лук", "Легкая кожаная броня и накладки")).
                    collect(Collectors.toList());

//            StringBuilder answer = new StringBuilder(); todo Доделать
//            answer.append("Пехота: ");
//            Infantry1stPlatoon.forEach(i -> answer.append(i.getLastName() + " "));
//            answer.append("; Лучники: ");
//            Archers1stPlatoon.forEach(i -> answer.append(i.getLastName() + " "));//Collection.merge
//            return answer.toString();
        } else {
            System.out.println("Не может быть, что-бы совсем никого не было! Отправить отряд для проверки в деревни!");
            return Collections.emptyList();
        }
    }


    public static boolean equalsAll (List<Peasant> expected, List<Peasant> actual) {
        if (expected.size() != actual.size()) {
            return false;
        } else {
          return expected.stream().anyMatch(l1 -> actual.stream().anyMatch(l1::equals));
        }
    }
}
