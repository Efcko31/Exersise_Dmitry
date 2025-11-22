package ru.CodeWars;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TexasHoldem {

    public TexasHoldemHand findPair(String[] holeCards, String[] communityCards) {
        HashMap<String, Integer> cardRank = new HashMap<>();
        cardRank.put("2", 2);
        cardRank.put("3", 3);
        cardRank.put("4", 4);
        cardRank.put("5", 5);
        cardRank.put("6", 6);
        cardRank.put("7", 7);
        cardRank.put("8", 8);
        cardRank.put("9", 9);
        cardRank.put("10", 10);
        cardRank.put("J", 11);
        cardRank.put("Q", 12);
        cardRank.put("K", 13);
        cardRank.put("A", 14);

        HashMap<String, Integer> numberCardsEachSuitHand = new HashMap<>();
        HashMap<String, Integer> numberCardsEachSuitCommunity = new HashMap<>();

        Arrays.stream(holeCards)
                .forEach(c -> numberCardsEachSuitHand.put(c.substring(c.length() - 1),
                        numberCardsEachSuitHand.getOrDefault(c.substring(c.length() - 1), 0) + 1));

        Arrays.stream(communityCards)
                .forEach(c -> numberCardsEachSuitCommunity.put(c.substring(c.length() - 1),
                        numberCardsEachSuitCommunity.getOrDefault(c.substring(c.length() - 1), 0) + 1));

        for (String key : numberCardsEachSuitHand.keySet()) {
            if (numberCardsEachSuitCommunity.containsKey(key) &&
                    numberCardsEachSuitHand.get(key) + numberCardsEachSuitCommunity.get(key) >= 5) { //suit = key
                return chekStraightFlush(key, holeCards, communityCards, cardRank);
            } else if (numberCardsEachSuitCommunity.size() == 1) {
                return chekStraightFlush(numberCardsEachSuitCommunity.keySet().iterator().next(),
                        holeCards, communityCards, cardRank);
            }
        }

        return new TexasHoldemHand("nothing", new String[]{"A", "Q", "9", "6", "3"});
    }

    public TexasHoldemHand chekStraightFlush(String suit,
                                             String[] holeCards,
                                             String[] communityCards,
                                             HashMap<String, Integer> cardRank) {

        ArrayList<String> numericRangHoleCard = Arrays.stream(holeCards)
                .filter(c -> c.contains(suit))
                .map(c -> c.replace(suit, ""))
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<String> numericRangCommunityCards = Arrays.stream(communityCards)
                .filter(c -> c.contains(suit))
                .map(c -> c.replace(suit, ""))
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<String> numericRangAll = Stream.concat(
                        numericRangHoleCard.stream(),
                        numericRangCommunityCards.stream()).sorted((s1, s2) -> {
                    int num1 = cardRank.get(s1);
                    int num2 = cardRank.get(s2);
                    return Integer.compare(num2, num1);
                })
                .collect(Collectors.toCollection(ArrayList::new));

        int sequenceCardCount = 0;
        String lowStraight = String.join("", numericRangAll);

        if (lowStraight.contains("A") && lowStraight.contains("5432")) {
            return new TexasHoldemHand("straight-flush", new String[]{"A", "5", "4", "3", "2"});
        } else {

            for (int i = 1; i < numericRangAll.size() && sequenceCardCount != 5; i++) {
                if (cardRank.get(numericRangAll.get(i - 1)) - cardRank.get(numericRangAll.get(i)) != 1) {
                    sequenceCardCount = 0;
                } else {
                    sequenceCardCount++;
                }
            }

            String[] answer = new String[5];
            for (int j = 0; j < 5; j++) {
                answer[j] = numericRangAll.get(j);
            }

            if (sequenceCardCount == 5) {
                return new TexasHoldemHand("straight-flush", answer);
            } else {
                return new TexasHoldemHand("flush", answer);
            }
        }
    }

    @Test
    void test1() {

        assertEquals(new TexasHoldemHand("straight-flush", new String[]{"J", "10", "9", "8", "7"}).getCombination(),
                findPair(new String[]{"8♠", "6♠"}, new String[]{"7♠", "5♠", "9♠", "J♠", "10♠"}).getCombination());
        assertEquals(new TexasHoldemHand("straight-flush", new String[]{"J", "10", "9", "8", "7"}).getCards()[0],
                findPair(new String[]{"8♠", "6♠"}, new String[]{"7♠", "5♠", "9♠", "J♠", "10♠"}).getCards()[0]);
        assertEquals(new TexasHoldemHand("straight-flush", new String[]{"J", "10", "9", "8", "7"}).getCards()[4],
                findPair(new String[]{"8♠", "6♠"}, new String[]{"7♠", "5♠", "9♠", "J♠", "10♠"}).getCards()[4]);

        assertEquals(new TexasHoldemHand("flush", new String[]{"Q", "J", "10", "5", "3"}).getCombination(),
                findPair(new String[]{"A♠", "K♦"}, new String[]{"J♥", "5♥", "10♥", "Q♥", "3♥"}).getCombination());
        assertEquals(new TexasHoldemHand("flush", new String[]{"Q", "J", "10", "5", "3"}).getCards()[0],
                findPair(new String[]{"A♠", "K♦"}, new String[]{"J♥", "5♥", "10♥", "Q♥", "3♥"}).getCards()[0]);
        assertEquals(new TexasHoldemHand("flush", new String[]{"Q", "J", "10", "5", "3"}).getCards()[4],
                findPair(new String[]{"A♠", "K♦"}, new String[]{"J♥", "5♥", "10♥", "Q♥", "3♥"}).getCards()[4]);

        //        assertEquals(new TexasHoldemHand("nothing", new String[]{"A", "K", "Q", "J", "9"}).getCombination(),
//                findPair(new String[]{"K♠", "A♦"}, new String[]{"J♣", "Q♥", "9♥", "2♥", "3♦"}).getCombination());
//        assertEquals(new TexasHoldemHand("nothing", new String[]{"A", "K", "Q", "J", "9"}).getCards(),
//                findPair(new String[]{"K♠", "A♦"}, new String[]{"J♣", "Q♥", "9♥", "2♥", "3♦"}).getCards());
    }
}





