package com.codingtest.exam.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 수 찾기
 * https://www.acmicpc.net/problem/1920
 */
public class P1920 {
    static int n, m;
    static int[] numbers;
    static int[] queries;

    public static void solution() {
        Arrays.sort(numbers);

        for (int query : queries) {
            System.out.println(search(query));
        }
    }

    public static int search(int x) {
        // 이진 탐색
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            // 찾는 숫자가 존재하는 경우 종료
            if (numbers[mid] == x) {
                return 1;
            } else if (numbers[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        m = sc.nextInt();
        queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
        }

        solution();
        sc.close();
    }
}
