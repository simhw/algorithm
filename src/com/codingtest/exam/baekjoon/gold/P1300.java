package com.codingtest.exam.baekjoon.gold;

import java.util.Scanner;

/**
 * K번째 수
 * https://www.acmicpc.net/problem/1300
 */
public class P1300 {
    static int N;
    static long K;

    public static void solution() {
        // 배열 원소 값의 범위
        long left = 1;
        long right = N * (long) N;

        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            // 각 행에서 mid보다 작거나 같은 수의 개수
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count < K) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextLong();
        solution();
        sc.close();
    }
}
