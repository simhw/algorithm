package com.codingtest.exam.thisiscodingtest.ch08;

import java.util.Arrays;
import java.util.Scanner;

// 예제 8-8 효율적인 화폐 구성  

// <문제>
// M 원을 만들기 위한 최소한의 화폐의 개수 

public class Ex05 {
    static int N, M;
    static int[] current;
    static int[] dp;
    static void input() {
        Scanner sc = new Scanner(System.in); 
        
        N = sc.nextInt();   // 화폐 단위 개수 
        M = sc.nextInt();   // 금액 
        current = new int[N];
        for (int i = 0; i < N; i++) {
            current[i] = sc.nextInt();
        }
        dp = new int[M + 1];
        for (int i = 1; i < M + 1; i++) {
            dp[i] = 10001;
        }
    }
    static void solution() {
        for (int i = 0; i < N; i++) {
            int x = current[i];
            dp[x] = 1;
        }

        for (int i = current[N - 1] + 1; i <= M; i++) {
            for (int j = 0; j < N; j++) {
                int k = current[j];
                if (i - k >= k) {
                    dp[i] = Math.min(dp[i], dp[i - k] + 1);
                }
            }
        }   
        System.out.println(Arrays.toString(dp));
    }

    public static void main(String[] args) {

/*
 2 15
 2
 3

 3 4
 3
 5
 7
 */
        input();
        solution();
    }
}
