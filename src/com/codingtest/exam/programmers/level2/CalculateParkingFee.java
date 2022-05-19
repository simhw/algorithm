package com.codingtest.exam.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CalculateParkingFee {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;

        HashMap<String, String> set = new HashMap<>();
        HashMap<String, Integer> accumulated = new HashMap<>();

        String[] inArr, outArr;
        int in, out;

        // 1. 누적 주차 시간 계산
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            if (set.containsKey(record[1])) {
                inArr = set.get(record[1]).split(":");
                in = Integer.parseInt(inArr[0]) * 60;
                in += Integer.parseInt(inArr[1]);
                outArr = record[0].split(":");
                out = Integer.parseInt(outArr[0]) * 60;
                out += Integer.parseInt(outArr[1]);

                accumulated.put(record[1], accumulated.getOrDefault(record[1], 0) + out - in);
                set.remove(record[1]);
            } else {
                set.put(record[1], record[0]);
            }
        }

        // 1-1. 출차된 내역이 없다면, 23:59에 출차된 것으로 간주한다.
        if (set.size() > 0) {
            for (String key : set.keySet()) {
                inArr = set.get(key).split(":");
                in = Integer.parseInt(inArr[0]) * 60;
                in += Integer.parseInt(inArr[1]);
                out = 23 * 60 + 59;
                accumulated.put(key, accumulated.getOrDefault(key, 0) + out - in);
            }
        }
        // 2. 주차 요금 계산
        List<String> sortedKeys = new ArrayList<>(accumulated.keySet());
        Collections.sort(sortedKeys);
        answer = new int[sortedKeys.size()];

        for (int i = 0; i < sortedKeys.size(); i++) {
            answer[i] = calculate(accumulated.get(sortedKeys.get(i)), fees);
        }

        return answer;
    }

    public int calculate(int accumulated, int[] fees) {
        int fee = 0;

        // 누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구합니다.
        // 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.

        // 기본 요금 + (초과 시간 / 단위 시간) * 단위 요금
        if (accumulated > fees[0]) {
            fee = fees[1] + (int) (Math.ceil((accumulated - fees[0]) / (fees[2] * 1.0)) * fees[3]);
        } else {
            fee = fees[1];
        }

        return fee;
    }

    public static void main(String[] args) {
        CalculateParkingFee calculateParkingFee = new CalculateParkingFee();
        calculateParkingFee.solution(new int[] { 1, 461, 1, 10 }, new String[] { "00:00 1234 IN" });
    }
}
