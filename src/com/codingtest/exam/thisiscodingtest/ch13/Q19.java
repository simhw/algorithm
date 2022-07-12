package com.codingtest.exam.thisiscodingtest.ch13;

import java.util.Scanner;

// 연산자 끼워 넣기
// 삼성전자 SW 역량테스트
public class Q19 {
    static int n;
    static int[] numbers;
    static int[] operators = new int[4];

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static void solution() {
        permutation(0, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    // + , -, *, /
    static int calculate(int op, int a, int b) {
        if (op == 0) {
            a += b;
        } else if (op == 1) {
            a -= b;
        } else if (op == 2) {
            a *= b;
        } else {
            a /= b;
        }
        return a;
    }

    static void permutation(int k, int result) {
        if (k == n - 1) {
            min = Math.min(min, result);
            max = Math.max(max, result);
        }
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i] -= 1;
                permutation(k + 1, calculate(i, result, numbers[k + 1]));
                operators[i] += 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }
        solution();
    }

}
