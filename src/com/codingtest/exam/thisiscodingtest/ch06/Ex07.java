package com.codingtest.exam.thisiscodingtest.ch06;

// 예제 6-12 두 배열의 원소 교체

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex07 {
    static int N, K;
    static Integer[] A, B;
    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        A = new Integer[N];
        B = new Integer[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }
    }
    static void solution() {
        int answer = 0;
        // 배열 A 는 오름차순 정렬
        Arrays.sort(A);
        // 배열 B 는 내림차순 정렬
        Arrays.sort(B, Collections.reverseOrder());

        // 첫 번째 인덱스부터 확인하며, 두 배열의 원소를 최대 K 번 비교
        for (int i = 0; i < K; i++) {
            // A 의 원소가 B 원소보다 작은 경우
            if (A[i] < B[i]) {
                // 두 원소 교체
                int temp = A[i];
                A[i] = B[i];
                B[i] = temp;
            } else {
                // A 의 원소가 B 원소보다 크거나 같을 때, 반복문 탈출
                break;
            }
        }
        for (int i = 0; i < N; i++) {
            answer += A[i];
        }
        System.out.println(answer);
    }
    public static void main(String[] args) {
        /*
5 3
1 2 5 4 3
5 5 6 6 5
         */
        input();
        solution();
    }
}
