package com.codingtest.exam.baekjoon.bronze;

import java.util.Scanner;

/**
 * 블랙잭
 * https://www.acmicpc.net/problem/2798
 */
public class P2798 {
    static int n, m;
    static int[] cards;

    public static void solution() {
        int answer = 0;

        for (int i = 0; i < n - 2; i++) {   // 첫 번째 카드
            for (int j = i + 1; j < n - 1; j++) {   // 두 번째 카드
                for (int k = j + 1; k < n; k++) {   // 세 번째 카드
                    int sum = cards[i] + cards[j] + cards[k];

                    // m을 넘지 않으면서 최대한 m과 가까운 합
                    if (sum <= m) {
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        solution();
        sc.close();
    }
}
