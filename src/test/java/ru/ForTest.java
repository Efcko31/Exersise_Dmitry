package ru;

import org.junit.jupiter.api.Test;

import javax.inject.Named;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Named
public class ForTest {
    public static void main(String[] args)  {
//        String suit = "♦";
//        String[] holeCards = new String[]{"K♠", "A♦"};
//        String[] communityCards = new String[]{"J♣", "Q♥", "9♥", "2♥", "3♦"};
//        HashMap<String, Integer> cardRank = new HashMap<>(
//                Map.of("J", 11, "Q", 12, "K", 13, "A", 14));
//
//        Integer i = cardRank.getOrDefault(holeCards[1].replace(suit,""),
//                Integer.parseInt(holeCards[1].replace(suit,"")));
//        System.out.println(i);

        ArrayList<String> test = new ArrayList<>(List.of("11", "5", "13", "2", "3"));
        test.stream().sorted(Comparator.comparingInt(Integer::parseInt));
        System.out.println(test);
//        String testfff = test.stream().map(Object::toString).collect(Collectors.joining(""));
//        System.out.println(testfff);
//        System.out.println(testfff.substring(4,8));

//        System.out.println("Suit: " + suit);
//        System.out.println("CardRank map: " + cardRank);
//
//        ArrayList<String> cardsOnlyRang = Stream.concat(
//                        Arrays.stream(holeCards),
//                        Arrays.stream(communityCards))
//                .peek(c -> System.out.println("Original card: " + c))
//                .filter(c -> {
//                    boolean contains = c.contains(suit);
//                    System.out.println("Card " + c + " contains suit " + suit + ": " + contains);
//                    return contains;
//                })
//                .map(s -> {
//                    String result = s.replace(suit, "");
//                    System.out.println("After removing suit: " + result);
//                    return result;
//                })
//                .sorted(Comparator.comparing(card -> {
//                    System.out.println("Processing card: " + card);
//                    Integer value = cardRank.getOrDefault(card, Integer.parseInt(card));
//                    System.out.println("Value: " + value);
//                    return value;
//                }))
//                .collect(Collectors.toCollection(ArrayList::new));
//
//        System.out.println("Result: " + cardsOnlyRang);

    }


}

