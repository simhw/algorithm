package com.codingtest.exam.thisiscodingtest.ch16;

import java.util.Scanner;

// 정수 삼각형 
public class Q32 {
    static int n;
    static int[][] dp;

    static void solution() {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int left, right;
                // 왼쪽 위에서 내려오는 경우 
                if (j == 0) {
                    left = 0;
                } else {
                    left = dp[i - 1][j - 1];
                }
                // 바로 위에서 내려오는 경우
                if (j == i) {
                    right = 0;
                } else {
                    right = dp[i - 1][j];
                }
                // 최대 합을 저장 
                dp[i][j] = dp[i][j] + Math.max(left, right);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        // input 
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = sc.nextInt();
            }
        }
        sc.close();
        solution();
    }
}
