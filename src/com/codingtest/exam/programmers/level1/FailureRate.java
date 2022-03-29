package com.codingtest.exam.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;

public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        // 0. 초기화
        // 스테이별 클리어하지 못한 플레이어 수 초기화
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int player;
        for (int i = 0; i < stages.length; i++) {
            player = stages[i];
            if (hashMap.containsKey(player)) {
                hashMap.put(player, hashMap.get(player) + 1);
            } else {
                hashMap.put(player, 1);
            }
        }
        // 1. 실패율 계산
        // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        for (int i: hashMap.keySet()) {

        }
        System.out.println(hashMap);
        return answer;
    }

    public static void main(String[] args) {
        FailureRate failureRate = new FailureRate();
        failureRate.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});

    }
}
