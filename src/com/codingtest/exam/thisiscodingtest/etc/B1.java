package com.codingtest.exam.thisiscodingtest.etc;

import java.util.Arrays;
import java.util.Scanner;

// 소수 구하기 
public class B1 {
    static int n, m;

    static void solution() {
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);
        // 1은 소수가 아님
        arr[1] = false;

        for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
            if (arr[i] == true) {
                // i를 제외한 i의 모든 배수를 제거하기
                int j = 2;
                while (i * j <= n) {
                    arr[i * j] = false;
                    j += 1;
                }
            }
        }

        for (int i = m; i < n + 1; i++) {
            if (arr[i] == true)
                System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        solution();
        sc.close();
    }
}
