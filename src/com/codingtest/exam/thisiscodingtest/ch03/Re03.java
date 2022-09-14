package com.codingtest.exam.thisiscodingtest.ch03;

import java.util.Arrays;

public class Re03 {
    // 거스름돈
    static void ex01() {
        int n = 1260;
        int count = 0;
        // 동전의 큰 단위가 항상 작은 단위의 배수의 형태
        int[] coins = { 500, 100, 50, 10 };

        for (int coin : coins) {
            count += n / coin;
            n %= coin;
        }

        System.out.println(count);
    }

    // 큰 수의 법칙
    static void ex02() {
        int n = 5, m = 8, k = 3;
        int[] arr = { 2, 4, 5, 4, 6 };

        Arrays.sort(arr);
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        int result = 0;
        int i = k;
        while (m > 0) {
            if (i > 0) {
                // 가장 큰 수를 k번 더하기
                result += first;
                i -= 1;
            } else {
                // 두 번째로 큰 수를 한 번 더하기
                result += second;
                i = k;
            }
            m -= 1;
        }

        System.out.println(result);
    }

    // 큰 수의 법칙
    static void ex03() {
        int n = 5, m = 8, k = 3;
        int[] arr = { 2, 4, 5, 4, 6 };

        Arrays.sort(arr);
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        int count = (int) (m / (k + 1)) * k;
        count += m % (k + 1);

        int result = 0;
        result += first * count;
        result += second * (m - count);

        System.out.println(result);
    }

    static void ex04() {
        int n = 3, m = 3;
        int[][] arr = {
                { 3, 1, 2 },
                { 4, 1, 4 },
                { 2, 2, 2 }
        };

        int result = 0;
        for (int i = 0; i < n; i++) {
            // 현재 줄에서 '가장 작은 수' 칮기
            int min = arr[i][0];
            for (int j = 1; j < m; j++) {
                min = Math.max(min, arr[i][j]);
            }
            // '가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, min);
        }
        System.out.println(result);
    }

    // 1이 될 때까지
    static void ex05() {
        int n = 25, k = 3;
        int result = 0;

        while (n != 1) {
            if (n % k == 0) {
                n /= k;
            } else {
                n -= 1;
            }
            result += 1;
        }

        System.out.println(result);
    }

    // 1이 될 때까지
    static void ex06() {
        int n = 25, k = 3;
        int result = 0;

        while (true) {
            // n이 k의 배수가 되는 수
            int target = (n / k) * k;
            result += (n - target);
            n = target;

            // n이 k보다 작을 때 (더 이상 나눌 수 없을 때) 탈출
            if (n < k) {
                break;
            }
            result += 1;
            n /= k;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += (n - 1);
        System.out.println(result);
    }

    public static void main(String[] args) {
        ex06();
    }
}
