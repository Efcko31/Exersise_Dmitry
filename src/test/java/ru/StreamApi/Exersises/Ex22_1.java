package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex22_1 {
    //Для каждого отправителя найти самое длинное сообщение
    @Test
    void findTheLongestMessageForEachSenderTest() {
        findTheLongestMessageForEachSender(Arrays.asList(
                new MessageForEx22_1("Alice", 50),
                new MessageForEx22_1("Bob", 100),
                new MessageForEx22_1("Alice", 200)
        ));
    }

    public void findTheLongestMessageForEachSender(List<MessageForEx22_1> messages) {
        Map<String, Integer> answer = messages.stream()
                .collect(Collectors.groupingBy(
                        MessageForEx22_1::getSender,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(MessageForEx22_1::getLength)),
                                l -> l.isPresent() ? l.get().getLength() : -1)));
        System.out.println(answer);
    }
}
