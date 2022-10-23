package com.codingtest.exam.thisiscodingtest.ch11;

import java.util.*;

public class Re11 {
    // 모험가 길드
    static void ex01() {
        int n = 5;
        int[] data = new int[] { 2, 3, 1, 2, 2 };

        int answer = 0; // 총 그룹의 수
        int cnt = 0; // 현재 그룹에 포함된 모험가의 수

        Arrays.sort(data);

        for (int i = 0; i < n; i++) {
            cnt += 1;
            if (cnt >= data[i]) {
                answer += 1;
                cnt = 0;
            }
        }
        System.out.println(answer);
    }

    // 곱하기 혹은 더하기
    static void ex02() {
        String data = "02984";

        int answer = data.charAt(0) - 48;

        for (int i = 1; i < data.length(); i++) {
            if (answer == 0 || data.charAt(i) - 48 == 0) {
                answer += data.charAt(i) - 48;
            } else {
                answer *= data.charAt(i) - 48;
            }
        }
        System.out.println(answer);
    }

    // 문자열 뒤집기
    static void ex03() {
        String data = "0001100";

        // 전부 0으로 바꾸는 경우, 전부 1로 바꾸는 경우
        int cnt0 = 0, cnt1 = 0;
        if (data.charAt(0) == '1') {
            cnt0 = 1;
        } else {
            cnt1 = 1;
        }

        for (int i = 0; i < data.length() - 1; i++) {
            if (data.charAt(i) != data.charAt(i + 1)) {
                if (data.charAt(i + 1) == '1') {
                    cnt0 += 1;
                } else {
                    cnt1 += 1;
                }
            }
        }
        System.out.println(Math.min(cnt0, cnt1));
    }

    // 만들 수 없는 금액
    static void ex04() {
        int n = 4;
        int[] data = { 3, 2, 1, 8 };

        int x = 1;
        Arrays.sort(data);

        for (int i = 0; i < n; i++) {
            if (x < data[i]) {
                break;
            } else {
                x += data[i];
            }
        }
        System.out.println(x);
    }

    // 볼링공 고르기
    static void ex05() {
        int n = 6, m = 3;
        int[] data = { 1, 3, 2, 3, 2, 2 };

        // 1부터 10까지 무게를 담을 수 있는 배열
        int[] weights = new int[11];

        for (int i : data) {
            // 각 무게 i에 해당하는 볼링공의 개수 카운트
            weights[i] += 1;
        }

        int answer = 0;
        for (int i = 1; i < m + 1; i++) {
            n -= weights[i]; // A가 선택할 수 있는 개수 제외
            answer += (weights[i] * n); // B가 선택할 수 있는 개수와 곱하기
        }
        System.out.println(answer);
    }

    // 무지의 먹방 라이브
    static int ex06(int[] food_times, long k) {
        // 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
        if (Arrays.stream(food_times).sum() <= k) {
            return -1;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < food_times.length; i++) {
            // 음식 번호, 음식 시간
            queue.add(new int[] { (i + 1), food_times[i] });
        }

        int sum = 0; // 먹기 위해 사용한 시간
        int previous = 0; // 직전에 다 먹은 음식 시간
        int length = food_times.length; // 남은 음식의 개수

        while (sum + ((queue.peek()[1]) - previous) * length <= k) {
            int now = queue.poll()[1];
            sum += (now - previous) * length;
            length -= 1;
            previous = now;
        }

        ArrayList<int[]> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        Collections.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        return result.get((int) (k - sum) % length)[0];
    }

    public static void main(String[] args) {
        // ex01();
        // ex02();
        // ex03();
        // ex04();
        // ex05();
        // ex06(new int[] { 8, 6, 4 }, 15);
    }
}
