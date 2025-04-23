package ru.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private String id;
    private String concertName;
    private boolean isValid;
    private Double price;

    public Optional<Double> getPrice() {
        return Optional.ofNullable(price);
    }
}
