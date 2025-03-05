package com.codingtest.exam.baekjoon.gold;

import java.util.Scanner;

/**
 * 연속합 2
 * https://www.acmicpc.net/problem/13398
 */
public class P13398 {
    static int n;
    static int[] numbers;

    public static void solution() {
        // 원소를 제거하지 않은 경우 최대 연속합
        int[] dp1 = new int[n];

        // 하나의 원소를 제거한 경우 최대 연속합
        int[] dp2 = new int[n];
        dp1[0] = numbers[0];

        int answer = dp1[0];

        for (int i = 1; i < n; i++) {
            // 현재 원소를 포함하는 경우와 새로운 수열을 시작하는 경우 중 큰 값
            dp1[i] = Math.max(dp1[i - 1] + numbers[i], numbers[i]);

            // 현재 원소를 제거하는 경우와 이전에 제거한 경우에 현재 원소를 포함
            dp2[i] = Math.max(dp1[i - 1], dp2[i - 1] + numbers[i]);

            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        solution();
        sc.close();
    }
}
