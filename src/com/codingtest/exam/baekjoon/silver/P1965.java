package com.codingtest.exam.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 상자넣기
 * https://www.acmicpc.net/problem/1965
 */
public class P1965 {
    static int n;
    static int[] boxes;

    public static int solution() {
        int answer;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            // 이전 박스 중 크기가 작은 박스 조회
            for (int j = 0; j < i; j++) {
                if (boxes[j] < boxes[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        answer = Arrays.stream(dp).max().orElse(1);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        boxes = new int[n];

        for (int i = 0; i < n; i++) {
            boxes[i] = sc.nextInt();
        }

        System.out.println(solution());
        sc.close();
    }
}
