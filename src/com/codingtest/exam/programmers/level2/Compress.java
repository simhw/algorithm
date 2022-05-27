package com.codingtest.exam.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;

public class Compress {
    // Lempel-Ziv-Welch Encoding

    public int[] solution(String msg) {
        int[] answer;
        HashMap<String, Integer> dictionary = new HashMap<>();
        String[] arr = msg.split("");

        // 1. 길이가 1 인 모든 단어를 포함하도록 사전을 초기화한다.
        for (int i = 0; i < 26; i++) {
            dictionary.put((char) ('A' + i) + "", i + 1);
        }

        ArrayList<Integer> output = new ArrayList<>(); // encoded
        String w = "", c = ""; // input, next

        // 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w 를 찾는다.
        for (int i = 0; i < arr.length; i++) {
            c = arr[i];
            if (dictionary.containsKey(w + c)) {
                // 4. 입력에서 처리되지 않은 다음 글자가 남아있다면 (c), w + c 에 해당하는 단어를 사전에 등록한다.
                w = w + c;
            } else {
                // 3. w 에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w 를 제거한다.
                output.add(dictionary.get(w));
                dictionary.put(w + c, dictionary.size() + 1);
                w = c;
            }
            // 5. 단계 2로 돌아간다.
        }

        if (w.length() > 0) {
            output.add(dictionary.get(w));
        }

        answer = new int[output.size()];
        for (int i = 0; i < output.size(); i++)
            answer[i] = output.get(i);

        System.out.println(output);
        return answer;
    }

    public static void main(String[] args) {
        Compress compress = new Compress();
        compress.solution("TOBEORNOTTOBEORTOBEORNOT");
        // result
        // [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
    }
}
