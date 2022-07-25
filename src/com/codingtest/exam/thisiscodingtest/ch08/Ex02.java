package com.codingtest.exam.thisiscodingtest.ch08;

import java.util.Scanner;

// 예제 8-5 1 로 만들기

public class Ex02 {
    static int X;
    static int dp[] = new int[3001];

    static void solution() {
        // bottom-up
        for (int i = 2; i <= X; i++) {
            // 현재의 수에서 1 을 빼는 경우
            // f(x - 1) 의 결과 값에서 + 1
            dp[i] = dp[i - 1] + 1;
            // 현재의 수가 2 로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            // 현재의 수가 3 으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            // 현재의 수가 5 로 나누어 떨어지는 경우
            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            }
        }
        System.out.println(dp[X]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        solution();
        sc.close();
    }
}
