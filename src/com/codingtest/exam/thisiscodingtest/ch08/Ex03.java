package com.codingtest.exam.thisiscodingtest.ch08;

// 예제 8-6 개미 전사

// <해결>
// 왼쪽부터 차례대로 식량창고를 털지 안털지
// 특정한 i 번째 식량창고를 털지 안털지의 여부 2 가지 경우에 대해서 확인

import java.util.Arrays;
import java.util.Scanner;

public class Ex03 {
    static int N;
    static int[] K;
    static int[] dp;
    static void solution() {
        dp[0] = K[0];
        dp[1] = K[1] > K[0] ? K[1] : K[0];
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + K[i]);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N - 1]);
    }
    public static void main(String[] args) {
        /*
6
3 1 1 5 7 2
         */
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 식량창고 개수
        K = new int[N];     // 식량창고에 저장된 식량의 개수
        for (int i = 0; i < N; i++) {
            K[i] = sc.nextInt();
        }
        dp = new int[N];
        solution();
        sc.close();
    }
}
