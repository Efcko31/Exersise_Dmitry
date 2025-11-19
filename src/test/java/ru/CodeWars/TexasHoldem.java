package ru.CodeWars;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TexasHoldem {

    public TexasHoldemHand findPair(String[] holeCards, String[] communityCards) {
        HashMap<String, String> cardRank = new HashMap<>(
                Map.of("J", "11", "Q", "12", "K", "13", "A", "14"));

        HashMap<String, Integer> numberCardsEachSuitHand = new HashMap<>();
        HashMap<String, Integer> numberCardsEachSuitCommunity = new HashMap<>();

        Arrays.stream(holeCards)
                .forEach(c -> numberCardsEachSuitHand.put(c.substring(1),
                        numberCardsEachSuitHand.getOrDefault(c.substring(1), 0) + 1));

        Arrays.stream(communityCards)
                .forEach(c -> numberCardsEachSuitCommunity.put(c.substring(1),
                        numberCardsEachSuitCommunity.getOrDefault(c.substring(1), 0) + 1));

        for (String key : numberCardsEachSuitHand.keySet()) {
            if (numberCardsEachSuitCommunity.containsKey(key) &&
                    numberCardsEachSuitHand.get(key) + numberCardsEachSuitCommunity.get(key) >= 5) { //suit = key

            }
        }

        return new TexasHoldemHand("nothing", new String[]{"A", "Q", "9", "6", "3"});
    }

    public void chekStraightFlush(String suit,
                                  String[] holeCards,
                                  String[] communityCards,
                                  HashMap<String, String> cardRank) {

        ArrayList<Integer> numericRang = Stream.concat(
                        Arrays.stream(holeCards),
                        Arrays.stream(communityCards))
                .filter(c -> c.contains(suit))
                .map(s -> s.replace(suit, ""))
                .map(c -> cardRank.getOrDefault(c, c))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        cardsOnlyRang.forEach(c -> System.out.print(c + " "));

//        List<Integer> numericRang = cardsOnlyRang.stream()
//                .map(c -> cardRank.getOrDefault(c, Integer.parseInt(c)))
//                .toList();
        numericRang.forEach(d -> System.out.println(d + " "));

        if (numericRang.size() >= 5) {
            boolean isStraightFlush = false;
            boolean isFlush = true;
            int sequenceCardCount = 0;

            String lowStraight = numericRang.toString();
            if (lowStraight.contains("A") && lowStraight.contains("2345")) {
                isStraightFlush = true;
            } else {
                int index = 0;
                for (int i = 1; i < numericRang.size() && sequenceCardCount != 5; i++) {
                    if (numericRang.get(i) - numericRang.get(i - 1) != 1) {
                        sequenceCardCount = 0;
                        index = i - 1;
                    } else {
                        sequenceCardCount++;
                    }
                }
//                if (sequenceCardCount == 5 & lowStraight.substring(index, index + 4).contains()) {
//                    isStraightFlush = true;
//                }
            }

        }
        //return new TexasHoldemHand("nothing", new String[]{"A", "Q", "9", "6", "3"});
    }

    @Test
    void test() {
        chekStraightFlush("♦", new String[]{"K♠", "A♦"}, new String[]{"J♣", "Q♥", "9♥", "2♥", "3♦"},
                new HashMap<>(Map.of("J", 11, "Q", 12, "K", 13, "A", 14)));
    }


//    @Test
//    void test1() {
//        assertEquals(new TexasHoldemHand("nothing", new String[]{"A", "K", "Q", "J", "9"}).getCombination(),
//                findPair(new String[]{"K♠", "A♦"}, new String[]{"J♣", "Q♥", "9♥", "2♥", "3♦"}).getCombination());
//        assertEquals(new TexasHoldemHand("nothing", new String[]{"A", "K", "Q", "J", "9"}).getCards(),
//                findPair(new String[]{"K♠", "A♦"}, new String[]{"J♣", "Q♥", "9♥", "2♥", "3♦"}).getCards());
//
//        assertEquals(new TexasHoldemHand("straight-flush", new String[]{"J", "10", "9", "8", "7"}).getCombination(),
//                findPair(new String[]{"8♠", "6♠"}, new String[]{"7♠", "5♠", "9♠", "J♠", "10♠"}).getCombination());
//        assertEquals(new TexasHoldemHand("straight-flush", new String[]{"J", "10", "9", "8", "7"}).getCards(),
//                findPair(new String[]{"8♠", "6♠"}, new String[]{"7♠", "5♠", "9♠", "J♠", "10♠"}).getCards());
//    }

}
