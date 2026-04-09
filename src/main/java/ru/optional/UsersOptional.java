package ru.optional;

import lombok.Getter;

import java.util.List;

import static ru.optional.ConstantForOptionalTraining.PRICE_GORE_OT_UMA;
import static ru.optional.ConstantForOptionalTraining.PRICE_IRONIYA_SUDBY;

@Getter
public enum UsersOptional {
    OLEG(new User("Олег", List.of(
            new Ticket("123456", "Горе от ума", true, PRICE_GORE_OT_UMA ),
            new Ticket("123654", "Ирония судьбы", true, PRICE_IRONIYA_SUDBY),
            new Ticket()))),
    ALEKSEY(new User("Алексей", List.of(
            new Ticket("236547", "Ирония судьбы", true, PRICE_IRONIYA_SUDBY),
            new Ticket(),
            new Ticket("123496", "Горе от ума", true, PRICE_GORE_OT_UMA)))),
    IVAN(new User("Иван", List.of(
            new Ticket("124356", "Горе от ума", true, PRICE_GORE_OT_UMA),
            new Ticket("124356", "Горе от ума", true, null),
            new Ticket("124356", "Горе от ума", false, PRICE_GORE_OT_UMA)))),
    ROMAN(new User("Роман", List.of(
            new Ticket("213456", "Ирония судьбы", true,PRICE_IRONIYA_SUDBY),
            new Ticket("236547", "Ирония судьбы", false, PRICE_IRONIYA_SUDBY),
            new Ticket("236547", "Ирония судьбы", true, null)))),
    ILYA(new User ("Илья", List.of(
            new Ticket("459632", "Ирония судьбы", false,PRICE_IRONIYA_SUDBY)))),
    DMITRY(new User("Дмитрий", List.of(
            new Ticket()))),
    ANTON(new User());
    private final User user;

    UsersOptional(User user) {
        this.user = user;
    }

}
