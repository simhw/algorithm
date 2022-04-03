package com.codingtest.exam.algorithm.practice.bruteforce;

// 조합
// ㅊ
public class BruteForce4 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected, used;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    static void recFunc(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            int start = selected[k - 1] + 1;

            for (int candidate = start; candidate <= N; candidate++) {
                selected[k] = candidate;
                recFunc(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소 중 조건에 맞는 모든 방법을 찾는다.
        recFunc(1);
        System.out.println(sb.toString());
    }

}
