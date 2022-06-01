package com.codingtest.exam.thisiscodingtest.ch03;
// 예제 3-2 큰 수의 법칙

// <해결>
// '가장 큰 수와 두 번째로 큰 수'만 저장한다.
// 가장 큰 수와 두 번째로 큰 수가 더해질 때 특정한 수열 형태로 일정하게 반복해서 더해지는 특성을 이용한다.

import java.util.Arrays;
import java.util.Scanner;

public class Ex02 {
    static int N, M, K;
    static int A[];
    public static void solution() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 배열의 크기
        int M = sc.nextInt();   // 숫자가 더해지는 횟수
        int K = sc.nextInt();   // 숫자가 연속해서 초과하여 더해질 수 없는 횟수

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 입력받은 수들 정렬하기
        Arrays.sort(A);

        // 가장 큰 수와 두 번째로 큰 수 저장
        int first = A[N - 1];
        int second = A[N - 2];

        int result = 0;

        // 가장 큰 수가 더해지는 횟수 계산
        int count = (M / (K + 1)) * K;
        // M 이 (K + 1) 로 나누어 떨어지지 않는 경우 고려
        count += M % (K + 1);

        result += count * first;
        result += (M - count) * second;

        System.out.println(result);
    }
    public static void main(String[] args) {
        solution();
    }
}
