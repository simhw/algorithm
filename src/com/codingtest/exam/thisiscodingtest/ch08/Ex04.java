package com.codingtest.exam.thisiscodingtest.ch08;

import java.util.Scanner;

// 예제 8-7 바닥 공사 

public class Ex04 {
    static int N;
    static int[] dp;
    static void solution() {
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + (2 * dp[i - 2]);
        }
        System.out.println(dp[N]);
    }
    public static void main(String[] args) {   
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N + 1];
        solution();
        sc.close();
    }
}