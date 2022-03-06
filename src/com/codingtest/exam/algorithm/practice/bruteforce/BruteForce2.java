package com.codingtest.exam.algorithm.practice.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

// N 개 중 중복없이, M 개를 순서있게 나열하는 알고리즘

public class BruteForce2 {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
        used = new int[N + 1];
    }

    static int N, M;
    static int[] selected, used;

    // M 개를 전부 고른 경우 조건에 맞는 탐색을 한 가지 성공한 것이고,
    // 아직 M 개를 고르지 않은 경우 k 번째부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
    static void recFunc(int k) {
        if (k == M + 1) {
            // selected[1...M] 배열이 새롭게 탐색된 결과를 출력해준다.
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n' );
        }
        else {
            for (int candidate = 1; candidate <= N; candidate++) {
                // (1) 중복을 체크해주는 알고리즘
                // 중복 값 체크
//                boolean isUsed = false;
//                for (int i = 0; i < k; i++) {
//                    if (candidate == selected[i]) {
//                        isUsed = true;
//                    }
//                }

                // (2) 중복을 체크해주는 알고리즘
                // 중복 값 배열 체크
                if (used[candidate] == 1) continue;

//                if (!isUsed) {
//                    selected[k] = candidate;
//                    // k + 1 번부터 M 번까지 채워주는 함수를 호출해준다.
//                    recFunc(k + 1);
//                    selected[k] = 0;
//                }

                selected[k] = candidate; used[candidate] = 1;

                recFunc(k + 1);

                selected[k] = 0; used[candidate] = 0;
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
