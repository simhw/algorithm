package com.codingtest.exam.baekjoon.bronze;

import java.util.Scanner;

/**
 * 분해합
 * https://www.acmicpc.net/problem/2231
 */
public class P2231 {
    static int N;

    public static void solution() {
        int answer = 0;

        // n에서 자릿수의 최대 합을 뺀 최솟값부터 탐색 
        for (int i = Math.max(1, N - String.valueOf(N).length() * 10); i < N; i++) {
            // n과 n을 이루는 각 자리수의 합
            int sum = i + digit(i);

            if (sum == N) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }

    // 자릿수의 합을 계산하는 함수
    private static int digit(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        solution();
        sc.close();
    }
}

