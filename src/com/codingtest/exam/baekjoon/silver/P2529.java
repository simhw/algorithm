package com.codingtest.exam.baekjoon.silver;

import java.util.Scanner;

/**
 * 부등호
 * https://www.acmicpc.net/problem/2529
 */
public class P2529 {
    static int k;
    static char[] a;

    static String max = "0";
    static String min = "999999999";

    public static void solution() {
        int[] candidate = new int[10];
        boolean[] used = new boolean[10];
        dfs(0, candidate, used);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int dept, int[] candidate, boolean[] used) {
        // 숫자를 모두 선택한 경우
        if (dept == k + 1) {
            if (check(candidate)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < k + 1; i++) {
                    sb.append(candidate[i]);
                }
                String current = sb.toString();
                if (current.compareTo(max) > 0) {
                    max = current;
                }
                if (current.compareTo(min) < 0) {
                    min = current;
                }
            }
            return;
        }

        // 숫자 0부터 9까지 선택
        for (int i = 0; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                candidate[dept] = i;
                dfs(dept + 1, candidate, used);
                used[i] = false;
            }
        }
    }

    // 부등호가 올바른지 확인
    public static boolean check(int[] numbers) {
        for (int i = 0; i < k; i++) {
            if (a[i] == '<' && numbers[i] >= numbers[i + 1]) {
                return false;
            }
            if (a[i] == '>' && numbers[i] <= numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();

        a = new char[k];
        for (int i = 0; i < k; i++) {
            a[i] = sc.next().charAt(0);
        }

        solution();
        sc.close();
    }
}
