package ru.StreamApi.AnArmyForTheKingTest;

import org.junit.jupiter.api.Test;
import ru.ArmyForKing.Units.Infantryman;
import ru.ArmyForKing.Units.Peasant;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.ArmyForKing.RecruitmentTheKingsArmy.*;
import static ru.StreamApi.AnArmyForTheKingTest.AllPeasant.*;

public class RecruitmentTheKingsArmyTest {

    public static List<Infantryman> infantrymanListTest = recruitsInfantryIntoArmy(ListOfThoseWhoCameTheArmySelection);
    @Test
    void test() {
        assertEquals(List.of(), recruitsInfantryIntoArmy(Collections.emptyList()));
        assertEquals(List.of(), recruitsArcherIntoArmy(Collections.emptyList()));
        assertEquals(List.of(), recruitsCavalryIntoArmy(Collections.emptyList()));

        assertTrue(equalsAll(List.of(antonIvanov, ivanSidorov, mikhailZadornov, nikolayVavilov),
                recruitsInfantryIntoArmy(ListOfThoseWhoCameTheArmySelection)));
        assertTrue(equalsAll(List.of(olegGagus, dmitryVagin, maksimStrelchonok),
                recruitsArcherIntoArmy(ListOfThoseWhoCameTheArmySelection)));
        assertTrue(equalsAll(List.of(ilyaInTheCube, ilyaIlyov, nikolayInTheCube, dementiyArhilov, dimaInTheCube),
                recruitsCavalryIntoArmy(ListOfThoseWhoCameTheArmySelection)));


        for (Peasant p : infantrymanListTest) {
            System.out.println(p + p.getLastName());
        }
    }

}
