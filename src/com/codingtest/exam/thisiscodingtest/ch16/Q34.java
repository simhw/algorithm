package com.codingtest.exam.thisiscodingtest.ch16;

import java.util.Scanner;

// 병사 배치하기 
public class Q34 {
    static int n;
    static int[] arr;
    static int[] dp;

    static void solution() {
        // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        // '가장 긴 감소하는 부분 수열' 알고리즘 수행
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 열외해야 하는 병사의 최소 수 출력
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(n - max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        solution();
    }
}
