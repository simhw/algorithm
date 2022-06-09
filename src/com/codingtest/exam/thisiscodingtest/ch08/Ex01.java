package com.codingtest.exam.thisiscodingtest.ch08;

// 피보나치 수열

public class Ex01 {
    static long[] array = new long[100];

    static long fibonacci(int n) {
        System.out.print("f(" + n + ") ");
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // top-down 방식
    static long memoization(int n) {
        System.out.print("f(" + n + ") ");
        if (n == 1 || n == 2) {
            return 1;
        }
        // 이미 계산한 적 있는 문제라면 그대로 반환
        if (array[n] != 0) {
            return array[n];
        }
        // 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
        array[n] = memoization(n - 1) + memoization(n - 2);
        return array[n];
    }

    // bottom-up 방식
    static long repeat(int n) {
        // 첫 번째 피보나치 수와 두 번째 피보나치 수는 1
        array[1] = 1;
        array[2] = 1;

        // 피보나치 함수 반복문으로 구현 (bottom-up 다이나믹 프로그래밍)
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public static void main(String[] args) {
//        System.out.println(fibonacci(6));
//        System.out.println(memoization(6));
//        System.out.println(repeat(55));
    }
}
