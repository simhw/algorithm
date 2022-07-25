package com.codingtest.exam.thisiscodingtest.ch07;

// 예제 7-5 부품 찾기

import java.util.Scanner;

public class Ex03 {
    static int N, M;
    static int[] A;
    static int[] B;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        M = sc.nextInt();
        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }
        sc.close();
    }

    static int search(int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static void solution() {
        // 요청한 부품 번호를 하나씩 확인
        for (int i = 0; i < M; i++) {
            int result = search(B[i], 0, N - 1);
            if (result > 0) {
                System.out.print("yes" + " ");
            } else {
                System.out.print("no" + " ");
            }
        }
    }

    public static void main(String[] args) {
        /*
5
8 3 7 9 2
3
5 7 9
         */
        input();
        solution();
    }
}
