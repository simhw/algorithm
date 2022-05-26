package com.codingtest.exam.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Compress {
    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        HashMap<String, Integer> dictionary = new HashMap<>();
        // Lempel-Ziv-Welch Encoding

        // 1. 길이가 1 인 모든 단어를 포함하도록 사전을 초기화한다.
        for (int i = 0; i < 26; i++) {
            dictionary.put((char) (65 + i) + "", i + 1);
        }

        // 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w 를 찾는다.
        String w = msg.charAt(0) + "";
        findW(dictionary, w, 0, msg);
        return answer;
    }

    public void findW(HashMap<String, Integer> dictionary, String w, int i, String msg) {
        if (!dictionary.containsKey(w) || i >= msg.length()) {
            dictionary.put(w, dictionary.size() + 1);
            System.out.println(dictionary);
            w = msg.charAt(i) + "";
            findW(dictionary, w, i, msg);
            return;
        } else {
            i++;
            w += msg.charAt(i);
            findW(dictionary, w, i, msg);
        }
    }



    public static void main(String[] args) {
        Compress compress = new Compress();
        compress.solution("KAKAO");
    }
}
