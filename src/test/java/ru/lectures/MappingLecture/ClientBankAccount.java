package ru.lectures.MappingLecture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientBankAccount {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String issueSeries;
    private String issueNumber;
    private BigDecimal amount;
    private String country;

}
