package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.CheckOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String nameDish;
    private int price;
    private List<String> ingredients;
}
