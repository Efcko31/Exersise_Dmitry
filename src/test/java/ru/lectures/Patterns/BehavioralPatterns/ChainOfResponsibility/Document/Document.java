package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Document {
    private String text;
    private String format;

}
