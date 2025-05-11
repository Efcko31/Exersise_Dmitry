package ru.ArmyForKing.Units;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;

import static ru.ArmyForKing.Utils.Constants.FEMALE_GENDER;
import static ru.ArmyForKing.Utils.Constants.MALE_GENDER;

@Getter
public enum AllPeasant {

    antonIvanov(new Peasant(
            "Антон",
            "Иванов",
            "Максимович",
            MALE_GENDER,
            30,
            85,
            "Два шрама на лице и несколько на руках.")),

    peterCheshkov(new Peasant(
            "Петр",
            "Чешков",
            "Ильич",
            MALE_GENDER,
            62,
            80,
            "Медлителен вследствии возраста")),
    artemShtilko(new Peasant(
            "Артем",
            "Штилько",
            "Максимович",
            MALE_GENDER,
            33,
            50,
            "Отсутствует на правой руке 4 пальца. Проиграл в кости на спор.")),
    irinaGalgadot(new Peasant(
            "Ирина",
            "Гальгадот",
            "Ивановна",
            FEMALE_GENDER,
            34,
            90,
            "Состояние здоровья удовлетворительное")),
    ivanSidorov(new Peasant(
            "Иван",
            "Сидоров",
            "Артемович",
            MALE_GENDER,
            32,
            85,
            "Состояние здоровья удовлетворительное")),
    olegGagus(new Peasant(
            "Олег",
            "Гагус",
            "Сергеевич",
            MALE_GENDER,
            28,
            65,
            "Периодически ссыться в портки.")),
    ilyaInTheCube(new Peasant(
            "Илья",
            "Илья",
            "Илья",
            MALE_GENDER,
            25,
            95,
            "Состояние здоровья Отличное")),
    dmitryVagin(new Peasant(
            "Дмитрий",
            "Вагин",
            "Михайлович",
            MALE_GENDER,
            34,
            65,
            "Хромает на правую ногу вследствии врожденного недуга")),
    mikhailZadornov(new Peasant(
            "Михаил",
            "Задорнов",
            "Иванович",
            MALE_GENDER,
            30,
            88,
            "Состояние здоровья удовлетворительное")),
    ekaterinaPrutnikova(new Peasant(
            "Екатерина",
            "Прутикова",
            "Ивановна",
            FEMALE_GENDER,
            21,
            95,
            "Состояние здоровья отличное")),
    maksimStrelchonok(new Peasant(
            "Максим",
            "Стрельчонок",
            "Николаевич",
            MALE_GENDER,
            22,
            65,
            "Дальнозоркость, все что ближе 2-х метров - почти не видит")),
    nikolayVavilov(new Peasant(
            "Николай",
            "Вавилов",
            "Александрович",
            MALE_GENDER,
            30,
            85,
            "Состояние здоровья удовлетворительное")),
    ilyaIlyov(new Peasant(
            "Илья",
            "Ильич",
            "Ильёвски",
            MALE_GENDER,
            20,
            95,
            "Состояние здоровья Отличное")),
    nikolayInTheCube(new Peasant(
            "Николай",
            "Николай",
            "Николай",
            MALE_GENDER,
            20,
            95,
            "Состояние здоровья Отличное")),
    dementiyArhilov(new Peasant(
            "Дементий",
            "Архилов",
            "Дементьевич",
            MALE_GENDER,
            21,
            95,
            "Состояние здоровья отличное")),
    dimaInTheCube(new Peasant(
            "Дима",
            "Дима",
            "Дима",
            MALE_GENDER,
            22,
            95,
            "Состояние здоровья отличное")),
    errorError(new Peasant(
            "Ошибка",
            "Архилов",
            "Error",
            MALE_GENDER,
            99,
            99,
            "Просто для теста"));

    private final Peasant peasant;

    AllPeasant(Peasant peasant) {
        this.peasant = peasant;
    }

    public static final List<Peasant> listOfThoseWhoCameTheArmySelection = List.of(antonIvanov.getPeasant(),
            peterCheshkov.getPeasant(), artemShtilko.getPeasant(), irinaGalgadot.getPeasant(),
            ivanSidorov.getPeasant(), olegGagus.getPeasant(), ilyaInTheCube.getPeasant(), dmitryVagin.getPeasant(),
            mikhailZadornov.getPeasant(), maksimStrelchonok.getPeasant(), nikolayVavilov.getPeasant(),
            ilyaIlyov.getPeasant(), nikolayInTheCube.getPeasant(), dementiyArhilov.getPeasant(),
            dimaInTheCube.getPeasant(), ekaterinaPrutnikova.getPeasant());

    public static  HashMap<String, Peasant> createListPeasantsWithHashMap() {
        HashMap<String, Peasant> listOfPeasantOnHashMap = new HashMap<>();

        for (Peasant i : listOfThoseWhoCameTheArmySelection) {
            listOfPeasantOnHashMap.put(i.getLastName(), i);
        }

        return listOfPeasantOnHashMap;
    }



}
