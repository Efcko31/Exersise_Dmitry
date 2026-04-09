package ru.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private List<Ticket> ListTickets;

    public Optional<List <Ticket>> getTicket() {
        return Optional.ofNullable(ListTickets);
    }
}
