package com.codingtest.exam.programmers.level2;

import java.util.*;

public class Tuple {
    public int[] solution(String s) {
        
        Map<String, Integer> hashMap = new HashMap<String, Integer>();

        s = s.replaceAll("[\\{\\}]", "");
        String[] str = s.split(",");

        for (int i = 0; i < str.length; i++) {
            if (hashMap.containsKey(str[i])) {
                hashMap.put(str[i], hashMap.get(str[i]) + 1);
            } else {
                hashMap.put(str[i], 1);
            }
        }
        
        List<String> keySet = new ArrayList<>(hashMap.keySet());
        keySet.sort((o1, o2) -> {
            return hashMap.get(o2) - hashMap.get(o1);        
        });

        int [] answer = new int[keySet.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(keySet.get(i));
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Tuple tuple = new Tuple();
        tuple.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
    }
}
