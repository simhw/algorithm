package com.codingtest.exam.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 설탕 배달
 * https://www.acmicpc.net/problem/2839
 */
public class P2839 {

    public static int N;

    public static void dp() {
        int answer = 0;
        int[] dp = new int[5001];
        Arrays.fill(dp, 5001);

        dp[3] = 1;
        dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
        }

        answer = dp[N] < 5001 ? dp[N] : -1;
        System.out.println(answer);
    }

    public static void greedy() {
        int answer = 0;

        while (N >= 0) {
            if (N % 5 == 0) {
                answer += N / 5;
                System.out.println(answer);
                return;
            }

            answer++;
            N -= 3;
        }

        System.out.println(-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp();
        sc.close();
    }
}
