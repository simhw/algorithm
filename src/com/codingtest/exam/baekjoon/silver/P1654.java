package com.codingtest.exam.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 랜선 자르기
 * https://www.acmicpc.net/problem/1654
 */

public class P1654 {
    // 갖고 있는 랜선 수, 필요한 랜선 수
    static int K, N;
    // 각 랜선의 길이
    static long[] cables;

    public static void solution() {
        long start = 1;
        // 자를 수 있는 최대 길이
        long end = Arrays.stream(cables).max().getAsLong();

        while (start <= end) {
            // 현재 길이로 만들 수 있는 랜선의 개수 계산
            long count = 0;
            long mid = (start + end) / 2;

            for (long cable : cables) {
                count += cable / mid;
            }

            if (count < N) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        K = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        cables = new long[K];
        for (int i = 0; i < K; i++) {
            cables[i] = Long.parseLong(br.readLine());
        }

        solution();
    }
}
