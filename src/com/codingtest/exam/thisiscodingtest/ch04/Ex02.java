package com.codingtest.exam.thisiscodingtest.ch04;

// 예제 4-2 시각

import java.util.Scanner;

public class Ex02 {
    static int N;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
    }

    static void solution() {
        int count = 0;

        // 시
        for (int i = 0; i < N + 1; i++) {
            // 분
            for (int j = 0; j < 60; j++) {
                // 초
                for (int k = 0; k < 60; k++) {
                    String time = i + "" + j + "" + k;
                    if (time.contains("3")) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        input();
        solution();
    }
}
