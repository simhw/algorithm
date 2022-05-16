package com.codingtest.exam.baekjoon;

// 특정 구간의 모든 수를 합한 값을 찾기

public class PrefixSum {
    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt(); // 수의 개수
        left = scan.nextInt();
        right = scan.nextInt();
        nums = new int[N]; // 수열
        for (int i = 0; i < N; i++) nums[i] = scan.nextInt();
    }

    static int N, left, right, answer;
    static int[] nums;
    static int[] preFixSum;

    static void solution() {
        int sum = 0;
        preFixSum = new int[N + 1];
        preFixSum[0] = sum;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            preFixSum[i + 1] = sum;
        }
        answer = preFixSum[right] - preFixSum[left - 1];
    }
    public static void main(String[] args) {
        input();
        solution();
        System.out.println(answer);
    }
}
