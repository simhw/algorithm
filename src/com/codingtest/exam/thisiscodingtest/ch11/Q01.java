package com.codingtest.exam.thisiscodingtest.ch11;

import java.util.Arrays;
import java.util.Scanner;

// 모험가 길드
// <해결>
// 오름차순으로 정렬하여 공포도가 가장 낮은 모험가부터 확인하면 항상 최소한의 모험가의 수만 포함하여 그룹 결성

public class Q01 {
    static int N;
    static int[] A;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
    }

    static void solution() {
        int result = 0;

        // 오름차순 정렬
        Arrays.sort(A);

        // 현재 그룹에 포함된 모험가의 수
        int count = 0;
        // 공포도가 낮은 것부터 하나씩 확인하며
        for (int i = 0; i < N; i++) {
            // 현재 그룹에 해당 모험가 포함
            count += 1;
            // 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
            if (count >= A[i]) {
                result += 1;
                count = 0;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        /*
5
2 3 1 2 2
         */
        input();
        solution();
    }
}
