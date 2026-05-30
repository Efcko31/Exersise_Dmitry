package ru.StreamApi.Exersises;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionForEx15 {
    private String currency;
    private Integer amount;
}
