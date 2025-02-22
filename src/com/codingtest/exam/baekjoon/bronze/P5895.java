package com.codingtest.exam.baekjoon.bronze;

import java.util.Scanner;

/**
 * 히든 넘버
 * https://www.acmicpc.net/problem/8595
 */
public class P5895 {

    static int n;
    static String s;

    public static void solution() {
        long total = 0;
        long number = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) { // 숫자인 경우
                number = number * 10 + (c - '0');   // 연속되는 숫자 확장
            } else {
                total += number;
                number = 0;
            }
        }

        total += number;
        System.out.println(total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        s = sc.nextLine();

        solution();
        sc.close();
    }
}
