package com.codingtest.exam.programmers.level1;

import java.util.HashMap;

public class NumberPlay {
    public int solution(String s) {
        int answer = 0;

        HashMap<String, Integer> words = new HashMap<>();
        words.put("zero", 0);
        words.put("one", 1);
        words.put("two", 2);
        words.put("three", 3);
        words.put("four", 4);
        words.put("five", 5);
        words.put("six", 6);
        words.put("seven", 7);
        words.put("eight", 8);
        words.put("nine", 9);

        for (String word:words.keySet()) {
            s = s.replace(word, words.get(word).toString());
        }

        answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        NumberPlay numberPlay = new NumberPlay();
        String s = "one4seveneight";
        numberPlay.solution(s);
    }
}
