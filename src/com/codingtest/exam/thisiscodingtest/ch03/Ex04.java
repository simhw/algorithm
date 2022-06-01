package com.codingtest.exam.thisiscodingtest.ch03;
// 예제 3-4 1 이 될 때까지

// <문제>
// 어떤 수 N 이 1 이 될 때까지
// 1. N 에서 1 을 뺀다.
// 2. N 을 K 로 나눈다.
// 두 과정 중 하나를 반복적으로 수행한다.

// <해결>
// 주어진 N 에 대하여 '최대한 많이 나누기'를 수행한다.
// K 가 이상이기만 하면 K 로 나누는 것이 1 을 빼는 것보다 항상 빠르게 N 의 값을 줄일 수 있다.

import java.util.Scanner;

public class Ex04 {
    static int N, K;

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        int result = 0;
        while (N > 1) {
            // N 이 K 로 나누어 떨어지는 수가 될 때까지만 1 씩 빼기
            int target = (N / K) * K;
            result += N - target;
            N = target;

            // N 이 K 보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (N < K) break;
            result += 1;
            N /= K;
        }
        System.out.println("result = " + result);
    }
    public static void main(String[] args) {
        solution();
    }
}
