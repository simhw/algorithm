package com.codingtest.exam.thisiscodingtest.etc;

import java.util.Arrays;

// 소수의 판별 
public class IsPrimeNumber {
    // 소수 판별 함수1
    static void solution1(int x) {
        boolean check = true;
        // 2부터 (x - 1)까지의 모든 수를 확인하며
        for (int i = 2; i < x; i++) {
            // x가 해당 수로 나누어떨어진다면
            if (x % i == 0) {
                // 소수가 아님
                check = false;
            }
        }
        System.out.println(check);
    }

    // 소수 판별 함수2
    static void solution2(int x) {
        boolean check = true;
        // 2부터 x의 제곱근까지의 모든 수를 확인하며
        for (int i = 2; i < (int) Math.sqrt(x) + 1; i++) {
            // x가 해당 수로 나누어떨어진다면
            if (x % i == 0) {
                // 소수가 아님
                check = false;
            }
        }
        System.out.println(check);
    }

    // 에라토스테네스의 체
    static void solution3(int n) {
        // 처음에는 모든 수가 소수(true)인 것으로 초기화(0과 1 제외)
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);

        // 2부터 x의 제곱근까지의 모든 수를 확인하며
        for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
            // i가 소수인 경우(남은 수인 경우)
            if (arr[i] == true) {
                // i를 제외한 i의 모든 배수를 지우기
                for (int j = 2; i * j <= n; j++) {
                    arr[i * j] = false;
                }
            }
        }

        // 모든 소수 출력
        for (int i = 2; i < n + 1; i++) {
            if (arr[i] == true) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        solution1(4);
        solution2(7);
        solution3(1000);
    }
}
