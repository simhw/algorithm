package com.codingtest.exam.algorithm.practice.bruteforce;

// N 개 중 중복을 허용하여, M 개를 선택하는 알고리즘

import java.io.*;
import java.util.StringTokenizer;

public class BruteForce3 {
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
//          selected[1...M] 배열이 새롭게 탐색된 결과를 출력해준다.
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            int start = selected[k - 1];
            if (start == 0) start = 1;

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

