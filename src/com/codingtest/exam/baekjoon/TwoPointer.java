package com.codingtest.exam.baekjoon;

// 특정한 합을 갖는 부분 연속 수열 찾기

public class TwoPointer {

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt(); // 수의 개수
        S = scan.nextInt(); // 합
        nums = new int[N + 1]; // 수열
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
    }

    static int N, S, answer;
    static int[] nums;

    // Two Pointers
    // 배열에 순차적으로 접근해야 할 때 두 개의 점을 이용해 위치를 기록하면서 접근한는 기법이다.
    static void pointer() {
        int value = 0;
        int end = 1;
        // start 를 차례대로 증가시키며 반복한다.
        for (int start = 1; start < nums.length; start++) {
            // end 를 가능한 만큼 이동시킨다.
            while (value < S && end < N + 1) {
                value += nums[end];
                end++;
            }
            if (value == S) {
                answer++;
            }
            value -= nums[start];
        }
    }

    public static void main(String[] args) {
        TwoPointer twoPointer = new TwoPointer();
        input();
        twoPointer.pointer();
        System.out.println(answer);
    }
}
