package com.codingtest.exam.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별 찍기 - 10
 * https://www.acmicpc.net/problem/2447
 */
public class P2447 {
    static int n;

    public static void solution() {
        String[] answer = divide(n);

        for (String line : answer) {
            System.out.println(line);
        }
    }

    public static String[] divide(int n) {
        if (n == 1) {
            return new String[]{"*"};
        }

        String[] stars = divide(n / 3);
        String[] result = new String[n];

        // 이전 패턴 가로 확장
        for (int i = 0; i < n / 3; i++) {
            result[i] = stars[i].repeat(3);
        }

        // 가운데 공백 처리
        for (int i = 0; i < n / 3; i++) {
            result[i + n / 3] = stars[i] + " ".repeat(n / 3) + stars[i];
        }

        // 이전 패턴 가로 확장
        for (int i = 0; i < n / 3; i++) {
            result[i + (2 * n) / 3] = stars[i].repeat(3);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        solution();
    }
}
