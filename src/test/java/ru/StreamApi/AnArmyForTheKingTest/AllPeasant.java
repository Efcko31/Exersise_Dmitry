package ru.StreamApi.AnArmyForTheKingTest;

import ru.ArmyForKing.Units.Peasant;

import java.util.List;

import static ru.ArmyForKing.Utils.Constants.FEMALE_GENDER;
import static ru.ArmyForKing.Utils.Constants.MALE_GENDER;

public class AllPeasant {


    public static Peasant antonIvanov = new Peasant(
            "Антон",
            "Иванов",
            "Максимович",
            MALE_GENDER,
            30,
            85,
            "Два шрама на лице и несколько на руках."
    );
    public static Peasant peterCheshkov = new Peasant(
            "Петр",
            "Чешков",
            "Ильич",
            MALE_GENDER,
            62,
            80,
            "Медлителен вследствии возраста"
    );
    public static Peasant artemShtilko = new Peasant(
            "Артем",
            "Штилько",
            "Максимович",
            MALE_GENDER,
            33,
            50,
            "Отсутствует на правой руке 4 пальца. Проиграл в кости на спор."
    );
    public static Peasant irinaGalgadot = new Peasant(
            "Ирина",
            "Гальгадот",
            "Ивановна",
            FEMALE_GENDER,
            34,
            90,
            "Состояние здоровья удовлетворительное"
    );
    public static Peasant ivanSidorov = new Peasant(
            "Иван",
            "Сидоров",
            "Артемович",
            MALE_GENDER,
            32,
            85,
            "Состояние здоровья удовлетворительное"
    );
    public static Peasant olegGagus = new Peasant(
            "Олег",
            "Гагус",
            "Сергеевич",
            MALE_GENDER,
            28,
            65,
            "Периодически ссыться в портки."
    );
    public static Peasant ilyaInTheCube = new Peasant(
            "Илья",
            "Илья",
            "Илья",
            MALE_GENDER,
            25,
            95,
            "Состояние здоровья Отличное"
    );
    public static Peasant dmitryVagin = new Peasant(
            "Дмитрий",
            "Вагин",
            "Михайлович",
            MALE_GENDER,
            34,
            65,
            "Хромает на правую ногу вследствии врожденного недуга"
    );
    public static Peasant mikhailZadornov = new Peasant(
            "Михаил",
            "Задорнов",
            "Иванович",
            MALE_GENDER,
            30,
            88,
            "Состояние здоровья удовлетворительное"
    );
    public static Peasant ekaterinaPrutnikova = new Peasant(
            "Екатерина",
            "Прутикова",
            "Ивановна",
            FEMALE_GENDER,
            21,
            95,
            "Состояние здоровья отличное"
    );
    public static Peasant maksimStrelchonok = new Peasant(
            "Максим",
            "Стрельчонок",
            "Николаевич",
            MALE_GENDER,
            22,
            65,
            "Дальнозоркость, все что ближе 2-х метров - почти не видит"
    );
    public static Peasant nikolayVavilov = new Peasant(
            "Николай",
            "Вавилов",
            "Александрович",
            MALE_GENDER,
            30,
            85,
            "Состояние здоровья удовлетворительное"
    );

    public static Peasant ilyaIlyov = new Peasant(
            "Илья",
            "Ильич",
            "Ильёвски",
            MALE_GENDER,
            20,
            95,
            "Состояние здоровья Отличное"
    );

    public static Peasant nikolayInTheCube = new Peasant(
            "Николай",
            "Николай",
            "Николай",
            MALE_GENDER,
            20,
            95,
            "Состояние здоровья Отличное"
    );

    public static Peasant dementiyArhilov = new Peasant(
            "Дементий",
            "Архилов",
            "Дементьевич",
            MALE_GENDER,
            21,
            95,
            "Состояние здоровья отличное"
    );

    public static Peasant dimaInTheCube = new Peasant(
            "Дима",
            "Дима",
            "Дима",
            MALE_GENDER,
            22,
            95,
            "Состояние здоровья отличное"
    );

    public static List<Peasant> ListOfThoseWhoCameTheArmySelection = List.of(antonIvanov, peterCheshkov, artemShtilko,
            irinaGalgadot, irinaGalgadot, ivanSidorov, olegGagus, ilyaInTheCube, dmitryVagin, mikhailZadornov,
            maksimStrelchonok, nikolayVavilov, ilyaIlyov, nikolayInTheCube, dementiyArhilov,
            dimaInTheCube, ekaterinaPrutnikova);

}
