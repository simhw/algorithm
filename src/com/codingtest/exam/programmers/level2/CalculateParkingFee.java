package com.codingtest.exam.programmers.level2;

import java.util.*;

public class CalculateParkingFee {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        HashMap<String, String> set = new HashMap<>();
        TreeMap<String, Integer> accumulated = new TreeMap<>();

        // 1. 누적 주차 시간 계산
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            if (set.containsKey(record[1])) {
                accumulated.put(record[1], accumulated.getOrDefault(record[1], 0) + parseMinute(record[0]) - parseMinute(set.get(record[1])));
                set.remove(record[1]);
            } else {
                set.put(record[1], record[0]);
            }
        }
        // 1-1. 출차된 내역이 없다면, 23:59에 출차된 것으로 간주한다.
        if (set.size() > 0) {
            for (String key : set.keySet()) {
                accumulated.put(key, accumulated.getOrDefault(key, 0) + 23 * 60 + 59 - parseMinute(set.get(key)));
            }
        }

        System.out.println(accumulated);
        
        // 2. 주차 요금 계산
        answer = new int[accumulated.size()];
        int i = 0;
        for (String key : accumulated.keySet()) {
            answer[i++] = calculate(accumulated.get(key), fees);
        }
        return answer;
    }

    public int calculate(int accumulated, int[] fees) {
        int fee = 0;
        // 기본 요금 + (초과 시간 / 단위 시간) * 단위 요금
        if (accumulated > fees[0]) {
            fee = fees[1] + (int) (Math.ceil((accumulated - fees[0]) / (fees[2] * 1.0)) * fees[3]);
        } else {
            fee = fees[1];
        }
        return fee;
    }
    public int parseMinute(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    public static void main(String[] args) {
        CalculateParkingFee calculateParkingFee = new CalculateParkingFee();
        calculateParkingFee.solution(new int[] { 180, 5000, 10, 600 }, new String[] { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
    }
}
