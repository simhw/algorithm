package com.codingtest.exam.baekjoon.gold;

import java.util.Scanner;

/**
 * 동전 1
 * https://www.acmicpc.net/problem/2293
 */
public class P2293 {
    static int n, k;
    static int[] coins;

    public static void solution() {
        int[] dp = new int[k + 1];
        // 아무 동전을 선택하지 않은 경우
        dp[0] = 1;

        for (int coin : coins) {
            // 현재 동전을 사용하는 경우 추가
            for (int x = coin; x <= k; x++) {
                dp[x] += dp[x - coin];
            }
        }

        System.out.println(dp[k]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        solution();
        sc.close();
    }
}
