package com.codingtest.exam.thisiscodingtest.ch12;

// 럭키 스트레이트

import java.util.Scanner;

public class Q07 {
    static String str;
    static char[] arr;

    static void input() {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        System.out.println(str);
        arr = str.toCharArray();
        sc.close();
    }

    static void solution() {
        int len = str.length();
        int sum = 0;
        // 왼쪽 부분 자릿수 합 더하기
        for (int i = 0; i < len / 2; i++) {
            sum += (int) arr[i];
        }
        // 오른쪽 부분 자릿수 합 빼기
        for (int i = len / 2; i < len; i++) {
            sum -= (int) arr[i];
        }
        if (sum == 0) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }

    }

    static void mysolution() {
        int mid = arr.length / 2;
        int left = 0;
        int right = 0;
        for (int i = 0; i < mid; i++) {
            left += arr[i] - 48;
        }
        for (int i = mid; i < arr.length; i++) {
            right += arr[i] - 48;
        }

        if (left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
