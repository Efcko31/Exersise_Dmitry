package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.Document;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpellChecker extends MiddlewareForDoc {

    @Override
    public boolean check(Document document) {
        Pattern pattern = Pattern.compile("[^A-Za-zА-Яа-я]"); //.*[0-9].*
        Matcher matcher = pattern.matcher(document.getText());
        if (matcher.matches()) {
            System.out.println("В тексте не должно быть цифр или символов");
            return false;
        }
        return checkNext(document);
    }
}
