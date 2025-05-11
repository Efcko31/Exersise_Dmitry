package ru.StreamApi.AnArmyForTheKingTest;

import org.junit.jupiter.api.Test;
import ru.ArmyForKing.Units.Peasant;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.ArmyForKing.RecruitmentTheKingsArmy.*;
import static ru.ArmyForKing.Units.AllPeasant.*;

public class RecruitmentTheKingsArmyTest {


    @Test
    void test() {

        assertEquals(List.of(), recruitsInfantryIntoArmy(Collections.emptyList()));
        assertEquals(List.of(), recruitsArcherIntoArmy(Collections.emptyList()));
        assertEquals(List.of(), recruitsCavalryIntoArmy(Collections.emptyList()));

        assertEquals(antonIvanov.getPeasant().getLastName(),
                recruitsInfantryIntoArmy(listOfThoseWhoCameTheArmySelection).getFirst().getLastName());
        assertEquals(nikolayVavilov.getPeasant().getLastName(),
                recruitsInfantryIntoArmy(listOfThoseWhoCameTheArmySelection).getLast().getLastName());

        assertEquals(olegGagus.getPeasant().getLastName(),
                recruitsArcherIntoArmy(listOfThoseWhoCameTheArmySelection).getFirst().getLastName());
        assertEquals(maksimStrelchonok.getPeasant().getLastName(),
                recruitsArcherIntoArmy(listOfThoseWhoCameTheArmySelection).getLast().getLastName());

        assertEquals(ilyaInTheCube.getPeasant().getLastName(),
                recruitsCavalryIntoArmy(listOfThoseWhoCameTheArmySelection).getFirst().getLastName());
        assertEquals(dimaInTheCube.getPeasant().getLastName(),
                recruitsCavalryIntoArmy(listOfThoseWhoCameTheArmySelection).getLast().getLastName());

    }

    @Test
    void hashMapListPeasantTest() {
        HashMap<String, Peasant> mapFromTest = createListPeasantsWithHashMap();

        assertEquals(16, mapFromTest.size());

        assertEquals(maksimStrelchonok.getPeasant(), mapFromTest.get("Стрельчонок"));
        assertEquals(ilyaInTheCube.getPeasant(), mapFromTest.get("Илья"));

        assertTrue(mapFromTest.containsKey("Дима"));
        assertFalse(mapFromTest.containsKey("Николаев"));

        assertTrue(mapFromTest.containsValue(olegGagus.getPeasant()));
        assertFalse(mapFromTest.containsValue(errorError.getPeasant()));

        assertEquals(dementiyArhilov.getPeasant(), mapFromTest.get("Архилов"));
        mapFromTest.put("Архилов", errorError.getPeasant());
        assertEquals(errorError.getPeasant(), mapFromTest.get("Архилов"));

    }
}
