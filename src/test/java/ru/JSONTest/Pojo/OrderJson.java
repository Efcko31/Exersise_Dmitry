package ru.JSONTest.Pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderJson {

    private int id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
}
