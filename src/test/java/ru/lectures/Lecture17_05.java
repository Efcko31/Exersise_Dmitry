package ru.lectures;

import org.junit.jupiter.api.Test;
import ru.Oop.GameByEfcko.Armor.Armor;
import ru.Oop.GameByEfcko.Enemies.Troll;
import ru.Oop.GameByEfcko.Weapon.Weapon;

public class Lecture17_05 {
    Armor trollSkin = new Armor(25);
    Weapon blockhead = new Weapon("Дубина", 20, 35);

    Troll troll1 = new Troll("Троль", 200, 200, trollSkin, blockhead);
    @Test
    void primitiveTest() {
        int a = 5;
        changeValue(a);
        System.out.println(a);
    }


    private void changeValue(int a){
        a = 10;
        System.out.println("in method:" + a);
    }

    @Test
    public void objectTest(){
        System.out.println(troll1.getName());
        changeObject(troll1);
        System.out.println(troll1.getName());
    }

    private void changeObject(Troll troll){
        troll.setName("Оглоша");
        System.out.println(troll.getName());
    }

    @Test
    void inboxing(){
        Integer i1 = 10;
        int i = i1;
        System.out.println(i);


        String s1 = "s1";
        String s2 = new String("s1");
    }
}
