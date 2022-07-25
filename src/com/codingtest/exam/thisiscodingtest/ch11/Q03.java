package com.codingtest.exam.thisiscodingtest.ch11;

// 문자열 뒤집기
// <해결>
// 전부 0 으로 바꾸는 경우와 전부 1 로 바꾸는 경우 중 더 적은 횟수를 가지는 경우를 계산

import java.util.Scanner;

public class Q03 {
    static String S;

    static void input() {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLine();
        sc.close();
    }

    static void solution() {
        int count0 = 0;     // 전부 0 으로 바꾸는 경우
        int count1 = 0;     // 전부 1 로 바꾸는 경우

        // 첫 번째 원소에 대해서 처리
        if (S.charAt(0) == '1') {
            count0 += 1;
        } else {
            count1 += 1;
        }
        // 두 번째 원소부터 모든 원소 확인
        for (int i = 1; i < S.length() - 1; i++) {
            if (S.charAt(i) != S.charAt(i + 1)) {
                // 다음 수에서 1 로 바뀌는 경우
                if (S.charAt(i + 1) == '1') {
                    count0 += 1;
                } else {
                    count1 += 1;
                }
            }
        }
        System.out.println(Math.min(count0, count1));
    }

    static void mysolution() {
        int result = 0;
        char start = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            if (start == S.charAt(i)) {
                continue;
            }
            while (i < S.length() && start != S.charAt(i)) {
                i += 1;
            }
            result += 1;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
