package com.codingtest.exam.thisiscodingtest.ch03;
// 예제 3-3 숫자 카드 게임

// <해결>
// '각 행마다 작은 수'를 찾은 뒤에 그 수 중에서 가장 큰 수를 찾는다.

import java.util.Arrays;
import java.util.Scanner;

public class Ex03 {
    static int N, M;
    static int A[];

    public static void solution() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();   // 행의 개수
        M = sc.nextInt();   // 열의 개수

        sc.nextLine();

        int result = 0;
        for (int i = 0; i < N; i++) {
            A = new int[N];
            // input
            for (int j = 0; j < M; j++) {
                A[j] = sc.nextInt();
            }
            int min = 10001;
            for (int j = 0; j < M; j++) {
                min = Math.min(min, A[j]);
            }
            result = Math.max(result, min);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        solution();
    }
}
