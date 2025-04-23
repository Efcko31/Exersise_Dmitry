package ru.StreamApi.AnArmyForTheKingTest;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.ArmyForKing.RecruitmentTheKingsArmy.*;
import static ru.StreamApi.AnArmyForTheKingTest.AllPeasant.*;

public class RecruitmentTheKingsArmyTest {

    @Test
    void test() {
        assertEquals(List.of(), recruitsInfantryIntoArmy(Collections.emptyList()));
        assertEquals(List.of(), recruitsArcherIntoArmy(Collections.emptyList()));
        assertEquals(List.of(), recruitsCavalryIntoArmy(Collections.emptyList()));

        assertEquals(antonIvanov.getLastName(), recruitsInfantryIntoArmy(ListOfThoseWhoCameTheArmySelection).getFirst().getLastName());
        assertEquals(nikolayVavilov.getLastName(), recruitsInfantryIntoArmy(ListOfThoseWhoCameTheArmySelection).getLast().getLastName());

        assertEquals(olegGagus.getLastName(), recruitsArcherIntoArmy(ListOfThoseWhoCameTheArmySelection).getFirst().getLastName());
        assertEquals(maksimStrelchonok.getLastName(), recruitsArcherIntoArmy(ListOfThoseWhoCameTheArmySelection).getLast().getLastName());

        assertEquals(ilyaInTheCube.getLastName(), recruitsCavalryIntoArmy(ListOfThoseWhoCameTheArmySelection).getFirst().getLastName());
        assertEquals(dimaInTheCube.getLastName(), recruitsCavalryIntoArmy(ListOfThoseWhoCameTheArmySelection).getLast().getLastName());

    }

}
