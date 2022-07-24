package com.codingtest.exam.thisiscodingtest.ch15;

import java.util.Scanner;

public class Q27 {
    static int n;
    static int x;
    static int[] arr;

    static void solution() {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            System.out.println("start:" + start + ", end:" + end + ", mid:" + mid);
            if (x > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        int cnt = 0;
        while (x == arr[start]) {
            cnt += 1;
            start += 1;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
/*
7 2
1 1 2 2 2 2 3
 */
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solution();
    }
}
