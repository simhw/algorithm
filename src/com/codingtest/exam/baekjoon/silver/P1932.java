package com.codingtest.exam.baekjoon.silver;

import java.util.Scanner;

/**
 * 정수 삼각형
 * https://www.acmicpc.net/problem/1932
 */
public class P1932 {
    static int n;
    static int[][] triangle;

    public static void solution() {
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 맨 왼쪽 원소 경우
                if (j == 0) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][0];
                } else {
                    dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        System.out.println(max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }
        solution();
        sc.close();
    }
}
