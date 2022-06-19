package com.codingtest.exam.thisiscodingtest.ch11;

// 무지의 먹방 라이브
// <해결>
// 시간이 적게 걸리는 음식부터 확인하는 탐욕적 접근 방식으로 해결

import java.util.*;

class Food implements Comparable<Food> {
    int time;
    int index;

    public Food(int amount, int index) {
        this.time = amount;
        this.index = index;
    }

    // 시간을 기준으로 오름차순
    @Override
    public int compareTo(Food o) {
        return this.time - o.time;
    }
}

public class Q06 {
    public int solution(int[] food_times, long k) {
        // 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
        long sum = 0;
        for (int i = 0; i < food_times.length; i++) {
            sum += food_times[i];
        }
        if (sum <= k) return -1;

        // 시간 기준으로 오름차순
        PriorityQueue<Food> queue = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            queue.add(new Food(food_times[i], i + 1));
        }

        // 직전에 다 먹은 음식 시간
        int previous = 0;
        // 남은 음식 개수
        long leave = food_times.length;

        // 남은 음식 개수 * 현재 음식 시간
        while ((queue.peek().time - previous) * leave <= k) {
            int time = queue.poll().time;
            k -= (time - previous) * leave;
            leave -= 1;
            previous = time;
        }

        ArrayList<Food> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        // 음식의 번호 기준으로 오름차순
        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.index - o2.index;
            }
        });

        return result.get((int) (k % leave)).index;
    }

    public static void main(String[] args) {
        Q06 q06 = new Q06();
        q06.solution(new int[]{8, 6, 4}, 15);
    }
}
