package com.codingtest.exam.thisiscodingtest.ch07;

import java.util.Arrays;

public class Re07 {
    // 이진 탐색(재귀함수)
    static int ex01(int[] arr, int x, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] > x) {
            return ex01(arr, x, start, mid - 1);
        } else {
            return ex01(arr, x, mid + 1, end);
        }
    }

    // 이진 탐색(반복문)
    static int ex02(int[] arr, int x, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // 부품 찾기
    static void ex03() {
        int n = 5, m = 3;
        int[] arr = new int[] { 8, 3, 7, 9, 2 };
        int[] x = new int[] { 5, 7, 9 };

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            int target = x[i];
            int start = 0, end = n - 1;
            boolean exist = false;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] == target) {
                    exist = true;
                    break;
                } else if (arr[mid] <= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            if (exist) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    // 떡볶이 떡 만들기
    static void ex04() {
        int n = 4, m = 6;
        int[] arr = new int[] { 19, 15, 10, 17 };

        Arrays.sort(arr);

        int start = 0, end = arr[n - 1];

        while (start <= end) {
            int x = 0;
            int h = (start + end) / 2;
            for (int i = 0; i < n; i++) {
                if (arr[i] > h) {
                    x += arr[i] - h;
                }
            }
            if (x < m) {
                end = h - 1;
            } else {
                start = h + 1;
            }
        }
        System.out.println(end);
    }

    public static void main(String[] args) {
        // int ex01 = ex01(new int[] { 1, 3, 5, 7, 9, 11, 13, 15, 19 }, 7, 0, 9);
        // int ex02 = ex02(new int[] { 1, 3, 5, 7, 9, 11, 13, 15, 19 }, 11, 0, 9);
        // ex03();
        // ex04();
    }
}
