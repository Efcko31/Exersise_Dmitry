package ru.Optional;

import java.util.List;
import java.util.Optional;

public class Methods {

    public static List<String> getValidTicketNumber(User user) {

        return Optional.ofNullable(user)
                .flatMap(User::getTicket).stream()
                .flatMap(List::stream)
                .filter(Ticket::isValid)
                .map(ticket -> String.format("Билет: %s, Цена: %s",
                        ticket.getId(),
                        ticket.getPrice().map(Object::toString)
                                .orElse("Цена не указана")))
                .toList();
    }

    public static List<String> getValidTicketNumberConcert(User user, String concert) {
        return Optional.ofNullable(user)
                .flatMap(User::getTicket)
                .stream()
                .flatMap(List::stream)
                .filter(ticket -> ticket.isValid() && concert.equals(ticket.getConcertName()))
                .map(ticket -> String.format("Билет: %s, Цена: %s",
                        ticket.getId(),
                        ticket.getPrice().map(Object::toString)
                                .orElse("Цена не указана")))
                .toList();
        //.orElseThrow(() -> new IllegalArgumentException("Билет не найден"));
    }


}
