package ru.Oop.PersonOop;

import org.junit.jupiter.api.Test;

public class PersonTest {

    Person men = new Person("Джон",33);
    Person women = new Person("Рэйчел",29);
    @Test
    void personTest() {
        men.move( "машет");
        women.talk("хуле машешь?");
        men.talk("А чё такая дерзкая?");
        men.move(  "пинает под зад");
    }
}
