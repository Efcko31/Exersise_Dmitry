package ru.myHashMapTest.exercises;

import org.junit.jupiter.api.Test;
import ru.myHashMap.MyHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordFrequency {
    public String testTotalWords(String sentence) {
        MyHashMap<String, Integer> total = new MyHashMap<>();
//       String sentWithoutSymbols = sentence.replaceAll("[^A-Za-zА-Яа-я]", "");
//       System.out.println(sentWithoutSymbols);
        String[] sentences = sentence.replaceAll("[^A-Za-zА-Яа-я\\s]", "").split(" ");

        for (int i = 0; i < sentences.length; i++) {
            if (!total.containsKey(sentences[i])) {
                total.put(sentences[i], 1);
            } else {
                total.put(sentences[i], total.get(sentences[i]) + 1);
            }
        }

        String answer = "";

        for (String str : total.keySet()) {
            answer += str + "=" + total.get(str) + "\n";
        }
        System.out.println(answer);
        return answer;

    }

    @Test
    void test() {
        assertEquals("Java=1\nworld=2\nhello=3\n", testTotalWords("hello, hello world, hello world Java"));
    }
}
