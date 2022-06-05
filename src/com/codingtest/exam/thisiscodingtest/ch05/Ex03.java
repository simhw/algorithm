package com.codingtest.exam.thisiscodingtest.ch05;

// 재귀 함수

public class Ex03 {
    static void recursive() {
        System.out.println("재귀 함수를 호출합니다. ");
        recursive();
    }
    static void recursive(int i) {
        // 100 번째 출력했을 때 종료되도록 종료 조건 명시
        if (i == 100) {
            return;
        }
        System.out.println(i + "번째 재귀 함수에서 " + i + 1 + "번째 재귀 함수를 호출합니다.");
        recursive(i + 1);
        System.out.println(i + "번째 재귀 함수를 종료합니다. ");
    }

    // 반복적으로 구현한 n!
    static int factorialIterative(int n) {
        int result = 1;
        for (int i = 1; i < n + 1; i++) {
            result *= i;
        }
        return result;
    }

    // 재귀적으로 구현한 n!
    static int factorialRecursive(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    public static void main(String[] args) {
        // Exception in thread "main" java.lang.StackOverflowError
        // recursive();
        // recursive(1);
        System.out.println(factorialIterative(5));
        System.out.println(factorialRecursive(5));
    }
}
