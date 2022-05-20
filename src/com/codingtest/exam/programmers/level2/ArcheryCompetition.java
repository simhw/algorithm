package com.codingtest.exam.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ArcheryCompetition {

    static HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

    public int[] solution(int n, int[] info) {
        int[] answer;

        // 각 점수를 아예 안 맞추거나 어피치보다 1발을 더 맞히는 경우로 각 점수(10점 ~ 0점)마다 2가지(총 2,048가지)를 완전 탐색한다.
        recursion(10, new int[11], n, info);
        System.out.println(hashMap);

        if (hashMap.size() > 0) {
            answer = new int[11];
            int max = Collections.max(hashMap.keySet());
            for (int i = 0; i < answer.length; i++) {
                answer[i] = hashMap.get(max).get(i);
            }
        } else {
            answer = new int[]{-1};
        }
        return answer;
    }

    public void recursion(int k, int[] scores, int n, int[] info) {
        if (k == -1) {
            int apeach = 0; int lion = 0;
            if (n < 0) {
                return;
            } else {
                scores[10] = n;
            }
            
            for (int i = 0; i < scores.length; i++) {
                if (scores[i] > info[i]) {
                    lion += (10 - i);
                } else {
                    if (info[i] != 0) apeach += (10 - i); 
                }
            }

            if (lion > apeach) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < scores.length; i++) {
                    list.add(scores[i]);
                }
                hashMap.put(lion, list);
            }

        } else {
            // k 점을 맞추는 경우
            scores[10 - k] = info[10 - k] + 1;
            recursion(k - 1, scores, n - scores[10 - k], info);
            // k 점을 안 맞추는 경우
            scores[10 - k] = 0;
            recursion(k - 1, scores, n + scores[10 - k], info);
        }
    }

    public static void main(String[] args) {
        ArcheryCompetition archeryCompetition = new ArcheryCompetition();
        archeryCompetition.solution(10, new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3 }); // 1,1,1,1,1,1,1,1,0,0,2
    }

}