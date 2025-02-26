package com.codingtest.exam.baekjoon.bronze;

import java.util.Scanner;

/**
 * 주사위 세개
 * https://www.acmicpc.net/problem/2480
 */
public class P2480 {
    static int a, b, c;

    public static void solution() {
        int answer = 0;
        // 같은 눈이 3개가 나오는 경우
        if (a == b && b == c) {
            answer = 10000 + a * 1000;
        }
        // 같은 눈이 2개만 나오는 경우
        else if (a == b || b == c || a == c) {
            if (a == b || a == c) {
                answer = 1000 + a * 100;
            } else {
                answer = 1000 + b * 100;
            }
        }
        // 모두 다른 눈이 나오는 경우
        else {
            answer = Math.max(a, Math.max(b, c)) * 100;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        solution();
        sc.close();
    }
}
