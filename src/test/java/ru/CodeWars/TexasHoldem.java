package ru.CodeWars;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TexasHoldem {

    public TexasHoldemHand findPair(String[] holeCards, String[] communityCards) {
        HashMap<String, Integer> cardRanks = new HashMap<>();
        cardRanks.put("2", 2);
        cardRanks.put("3", 3);
        cardRanks.put("4", 4);
        cardRanks.put("5", 5);
        cardRanks.put("6", 6);
        cardRanks.put("7", 7);
        cardRanks.put("8", 8);
        cardRanks.put("9", 9);
        cardRanks.put("10", 10);
        cardRanks.put("J", 11);
        cardRanks.put("Q", 12);
        cardRanks.put("K", 13);
        cardRanks.put("A", 14);

        List<String> allRank = new ArrayList<>();
        allRank.addAll(Arrays.asList(holeCards));
        allRank.addAll(Arrays.asList(communityCards));

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
                return chekCombinationsCardsBySuit(key, holeCards, communityCards, cardRanks);
            } else if (numberCardsEachSuitCommunity.size() == 1) {
                return chekCombinationsCardsBySuit(numberCardsEachSuitCommunity.keySet().iterator().next(),
                        holeCards, communityCards, cardRanks);
            }
        }

//        HashMap<String, Integer> numberCardsByRankHand = new HashMap<>();
//        HashMap<String, Integer> numberCardsByRankCommunity = new HashMap<>();
//
//        Arrays.stream(holeCards).forEach(c -> numberCardsByRankHand.put(c.substring(0, c.length() - 2),
//                numberCardsByRankHand.getOrDefault(c.substring(0, c.length() - 2), 0) + 1));
//        Arrays.stream(holeCards).forEach(c -> numberCardsByRankCommunity.put(c.substring(0, c.length() - 2),
//                numberCardsByRankCommunity.getOrDefault(c.substring(0, c.length() - 2), 0) + 1));


        return new TexasHoldemHand("nothing", new String[]{"A", "Q", "9", "6", "3"});
    }

    public TexasHoldemHand chekCombinationsCardsBySuit(String suit,
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

    public TexasHoldemHand checkCardCombinationByRank(List<String> allRank,
                                                      HashMap<String, Integer> cardRanks) {

        HashMap<String, Integer> allRankMap = new HashMap<>();
        allRank.forEach(s -> allRankMap.put(s, allRankMap.getOrDefault(s, 0) + 1));

        String fourRank = null;
        String kicker = null;
        for (Map.Entry<String, Integer> entry : allRankMap.entrySet()) {
            if (entry.getValue() == 4) {
                fourRank = entry.getKey();
            } else if (kicker == null || cardRanks.get(entry.getKey()) > cardRanks.get(kicker)) {
                kicker = entry.getKey();
            }
        }
        if (fourRank != null) {
            return new TexasHoldemHand("four-rank", new String[]{fourRank, kicker});
        }

        return null;
    }

    public TexasHoldemHand checkFullHouse(List<String> allRank,
                                          HashMap<String, Integer> cardRanks) {
        HashMap<String, Integer> allRankMap = new HashMap<>();
        allRank.forEach(s -> allRankMap.put(s, allRankMap.getOrDefault(s, 0) + 1));

        String threeRank = null;
        String twoRank = null;

        for (Map.Entry<String, Integer> entry : allRankMap.entrySet()) {
            if (entry.getValue() == 3) {
                if (threeRank == null || cardRanks.get(entry.getKey()) > cardRanks.get(threeRank)) {
                    threeRank = entry.getKey();
                }
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





