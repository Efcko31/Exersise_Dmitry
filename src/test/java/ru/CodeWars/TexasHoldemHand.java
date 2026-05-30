package ru.CodeWars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TexasHoldemHand {
    private String combination;
    private String[] cards;
}
