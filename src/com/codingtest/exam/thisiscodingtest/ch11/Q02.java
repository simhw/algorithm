package com.codingtest.exam.thisiscodingtest.ch11;

// 곱하기 혹은 더하기
// <해결>
// 대분의 경우 곱하기를 수행한 결괏값이 더 크나
// 두 수 중에서 하나라도 0 혹은 1 인 경우, 더하기를 수행하는 것이 효율적

import java.util.Scanner;

public class Q02 {
    static String S;

    static void input() {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLine();
    }

    static void solution() {
        int result = S.charAt(0) - 48;
        for (int i = 1; i < S.length(); i++) {
            int x = S.charAt(i) - 48;
            // 두 수 중에서 하나라도 0 혹은 1 인 경우, 곱하기 보다는 더하기 수행
            if (result <= 1 || x <= 1) {
                result += x;
            } else {
                result *= x;
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
