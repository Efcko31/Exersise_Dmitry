package ru.StreamApi.Exersises;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionForEx8 {
    private String accountId ;
    private Integer amount ;
    private String type;
}
