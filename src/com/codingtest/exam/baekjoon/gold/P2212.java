package com.codingtest.exam.baekjoon.gold;

import java.util.*;

/**
 * 센서
 * https://www.acmicpc.net/problem/2212
 */
public class P2212 {
    // 센서 수, 집중국 수
    static int n, k;
    static int[] sensors;

    public static void solution() {
        int answer = 0;
        Arrays.sort(sensors);

        // 거리를 정렬하여 가장 큰 거리부터 처리
        List<Integer> distances = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            distances.add(sensors[i] - sensors[i - 1]);
        }

        Collections.sort(distances);

        // k - 1개 가장 큰 거리 제외
        int max = sensors[n - 1] - sensors[0];

        for (int i = 0; i < Math.min(k - 1, n - 1); i++) {
            max -= distances.get(distances.size() - 1 - i);
        }

        answer = Math.max(max, answer);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        sensors = new int[n];
        for (int i = 0; i < n; i++) {
            sensors[i] = sc.nextInt();
        }

        solution();
        sc.close();
    }
}
