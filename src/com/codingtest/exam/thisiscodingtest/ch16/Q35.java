package com.codingtest.exam.thisiscodingtest.ch16;

import java.util.*;

// 못생긴 수 
public class Q35 {
    static int n;
    static int[] dp;

    static void solution() {
        dp = new int[n];
        dp[0] = 1;

        // 못생긴 수에 2, 3 혹은 5를 곱한 수 또한 '못생긴 수'에 해당
        // 2배, 3배, 5배를 위한 인덱스
        int i2 = 0, i3 = 0, i5 = 0;

        // 처음 곱셈값 초기화
        int d2 = 2, d3 = 3, d5 = 5;

        // 1부터 n까지의 못생긴 수 찾기
        for (int i = 1; i < n; i++) {
            // 가능한 곱셈 결과 중 가장 작은 수 선택
            dp[i] = Math.min(d2, Math.min(d3, d5));
            // 인덱스에 따라 곱셈 결과 증가
            if (dp[i] == d2) {
                i2 += 1;
                d2 = dp[i2] * 2;
            }
            if (dp[i] == d3) {
                i3 += 1;
                d3 = dp[i3] * 3;
            }
            if (dp[i] == d5) {
                i5 += 1;
                d5 = dp[i5] * 5;
            }
        }
        System.out.println(dp[n - 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();
        solution();
    }
}
