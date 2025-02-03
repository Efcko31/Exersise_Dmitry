package ru.Oop.AnArmyForTheKing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.Oop.AnArmyForTheKing.AllPeasant.*;

public class RecruitmentTheKingsArmy {
    List<Infantryman> infantry1stPlatoon = new ArrayList<>();
    List<Infantryman> archers1stPlatoon = new ArrayList<>();

    @Test
    void test() {
        assertEquals("Пехота: Иванов Сидоров Задорнов Вавилов ; Лучники: Гагус Вагин Стрельчонок ",
                selectionPeasantsForArmy(infantry1stPlatoon, archers1stPlatoon,
                antonIvanov, peterCheshkov, artemShtilko, irinaGalgadot, ivanSidorov, olegGagus, dmitryVagin,
                mikhailZadornov, maksimStrelchonok, nikolayVavilov));
        assertEquals("",
                selectionPeasantsForArmy(infantry1stPlatoon, archers1stPlatoon));
    }

    public String selectionPeasantsForArmy(List<Infantryman> Infantry1stPlatoon,
                                           List<Infantryman> Archers1stPlatoon, Peasant... peasants) {
        if (peasants.length > 0) {
            Arrays.stream(peasants).toList().stream().
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
                            "Кольчугаб шлемб пластины на запястье")).
                    forEach(Infantry1stPlatoon::add);

            Arrays.stream(peasants).toList().stream().
                    filter(i -> "М".equals(i.getGender()) && i.getAge() < 60 && i.getHealthAssessment() > 50 && i.getHealthAssessment() < 66).
                    map(i -> new Infantryman(
                            i.getFirstName(),
                            i.getLastName(),
                            i.getPatronymic(),
                            i.getGender(),
                            i.getAge(),
                            i.getHealthAssessment(),
                            i.getDescription(), "Длинный лук", "Легкая кожаная броня и накладки")).
                    forEach(Archers1stPlatoon::add);

            StringBuilder answer = new StringBuilder();
            answer.append("Пехота: ");
            Infantry1stPlatoon.forEach(i -> answer.append(i.getLastName() + " "));
            answer.append("; Лучники: ");
            Archers1stPlatoon.forEach(i -> answer.append(i.getLastName() + " "));
            return answer.toString();
        } else {
            System.out.println("Не может быть, что-бы совсем никого не было! Отправить отряд для проверки в деревни!");
            return "";
        }
    }
}
