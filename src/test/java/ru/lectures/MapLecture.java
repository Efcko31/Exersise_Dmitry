package ru.lectures;

import org.junit.jupiter.api.Test;
import ru.ArmyForKing.Units.Peasant;

import java.util.HashMap;
import java.util.Map;

import static ru.ArmyForKing.Units.AllPeasant.dementiyArhilov;

public class MapLecture {

    @Test
    public void mapExample(){

        Map<String, Peasant> peasantMap = new HashMap<>();

        peasantMap.put("Архилов", dementiyArhilov.getPeasant());

        System.out.println(peasantMap.get("Архилов").toString());

        //мапу нельзя итерировать в классическом понимании
        peasantMap.entrySet().stream().forEach(stringPeasantEntry -> System.out.println(stringPeasantEntry.getKey() + stringPeasantEntry.getValue().toString()));


    }
}
