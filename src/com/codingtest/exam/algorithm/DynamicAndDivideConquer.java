package com.codingtest.exam.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class DynamicAndDivideConquer {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
         return fibonacci(n - 2) + fibonacci(n - 1);
    }
    public static int dynamic(int n) {
        Integer[] cache = new Integer[n];
        cache[0] = 1;
        cache[1] = 1;
        // Memoization 기법
        for (int i = 2; i < n; i++) {
            cache[i] = cache[i - 2] + cache[i - 1];
        }
        System.out.println(Arrays.toString(cache));
        return cache[n - 1];
    }

    public static void main(String[] args) {
        // n의 값이 커지면 overflow 가 발생한다.
        int fibo = fibonacci(30);
        System.out.println(fibo);

        int dynamic = dynamic(30);
        System.out.println(dynamic);

    }
}
