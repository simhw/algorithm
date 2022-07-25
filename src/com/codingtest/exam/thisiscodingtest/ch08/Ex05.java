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
        M = sc.nextInt();   // 화폐 개수 최소한의 금액
        current = new int[N];
        for (int i = 0; i < N; i++) {
            current[i] = sc.nextInt();
        }
        // 초기화
        // 10001 은 특정 금액을 만들 수 있는 화폐 구성이 가능하지 않다는 의미
        dp = new int[M + 1];
        // 0 원의 경우, 화폐를 하나도 사용하지 않았을 때 만들 수 있으므로 0 으로 설정
        for (int i = 1; i < M + 1; i++) {
            dp[i] = 10001;
        }
        sc.close();
    }

    static void solution() {
        for (int i = 0; i < N; i++) {
            int x = current[i];
            dp[x] = 1;
        }

        for (int i = 0; i < N; i++) {
            int k = current[i];
            for (int j = k; j < M + 1; j++) {
                // (i - k) 원을 만드는 방법이 존재하는 경우
                if (dp[j - k] != 10001) {
                    dp[j] = Math.min(dp[j], dp[j - k] + 1);
                    System.out.println(Arrays.toString(dp));
                }
            }
        }
        if (dp[M] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[M]);
        }
    }

    public static void main(String[] args) {
        input();
        solution();
/*
 2 15
 2
 3

 3 4
 3
 5
 7
 */
    }
}
