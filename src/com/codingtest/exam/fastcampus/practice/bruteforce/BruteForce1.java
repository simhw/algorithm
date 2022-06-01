package com.codingtest.exam.fastcampus.practice.bruteforce;

import com.codingtest.exam.fastcampus.practice.FastReader;
// 중복 순열 
// N 개 중 중복을 허용하여, M 개를 순서있게 나열하는 알고리즘

public class BruteForce1 {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    static int N, M;
    static int[] selected;

    // M 개를 전부 고른 경우 조건에 맞는 탐색을 한 가지 성공한 것이고,
    // 아직 M 개를 고르지 않은 경우 k 번째부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
    static void recFunc(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
                System.out.println(selected[i] + " ");
            }
            sb.append('\n' );
            System.out.println();
        }
        else {
            for (int candidate = 1; candidate <= N; candidate++) {
                selected[k] = candidate;
                // k + 1 번부터 M 번까지 채워주는 함수를 호출해준다.
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
