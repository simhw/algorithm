package com.codingtest.exam.thisiscodingtest.ch11;

import java.util.Arrays;
import java.util.Scanner;

public class Q05 {
    static int N, M;
    static int[] A;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 공의 개수
        M = sc.nextInt();   // 공의 최대 무게
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        sc.close();
    }

    static void solution() {
        // 1 부터 10 까지의 무게를 담을 수 있는 배열
        int[] array = new int[11];

        // 무게마다 볼링공이 몇 개 있는지 구하기
        for (int i = 0; i < N; i++) {
            array[A[i]] += 1;
        }

        // A 를 기준으로 무게가 낮은 볼링공부터 선택했을 때, B 가 볼링공을 선택하는 경우
        int result = 0;
        for (int i = 1; i < M + 1; i++) {
            // A 가 선택할 수 있는 개수 제외
            N -= array[i];
            result += array[i] * N;
        }
        System.out.println(result);
    }

    static void mysolution() {
        Arrays.sort(A);
        // 중복되는 조합의 수 구하기
        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            if (A[i] != A[i + 1]) {
                continue;
            }
            int j = i;
            while (j < N - 1 && A[i] == A[j + 1]) {
                count += 1;
                j += 1;
            }
        }
        // 조합 연산
        int total = (N * (N - 1)) / 2;
        System.out.println(total - count);
    }

    public static void main(String[] args) {
        /*
8 5
1 5 4 3 2 4 5 2
         */
        input();
        solution();
    }
}
