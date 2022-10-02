package com.codingtest.exam.thisiscodingtest.ch08;

import java.util.Arrays;

public class Re08 {
    // 1로 만들기
    static int ex01(int x, int[] d) {
        if (x == 1)
            return 0;
        if (d[x] != 0) {
            return d[x];
        }
        if (x % 5 == 0) {
            d[x] = Math.min(ex01(x - 1, d) + 1, ex01(x / 5, d) + 1);
        } else if (x % 3 == 0) {
            d[x] = Math.min(ex01(x - 1, d) + 1, ex01(x / 3, d) + 1);
        } else if (x % 2 == 0) {
            d[x] = Math.min(ex01(x - 1, d) + 1, ex01(x / 2, d) + 1);
        } else {
            d[x] = ex01(x - 1, d) + 1;
        }
        return d[x];
    }

    // 개미 전사
    static void ex02(int x, int[] arr) {
        int[] d = new int[x];
        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < x; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
        }
        System.out.println(d[x - 1]);
    }

    // 바닥 공사
    static void ex03(int n) {
        int[] d = new int[n + 1];
        d[1] = 1;
        d[2] = 3;

        for (int i = 3; i < n + 1; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 2];
        }
        System.out.println(d[n]);
    }

    // 효율적인 화폐 구성
    static void ex04(int n, int k, int[] currencies) {
        int[] d = new int[k + 1];
        Arrays.fill(d, 10001);

        d[0] = 0;
        for (int i = 0; i < n; i++) {
            int currency = currencies[i];
            for (int j = currency; j < k + 1; j++) {
                d[j] = Math.min(d[j], d[j - currency] + 1);
            }
        }
        System.out.println(d[k]);
    }

    public static void main(String[] args) {
        // ex01(26, new int[27]);
        // ex02(4, new int[] { 1, 3, 1, 5 });
        // ex03(4);
        // ex04(3, 7, new int[] { 2, 3, 5 });
    }
}
