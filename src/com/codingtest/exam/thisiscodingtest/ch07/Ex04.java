package com.codingtest.exam.thisiscodingtest.ch07;

// 예제 7-8 떡볶이 떡 만들기
// <해결>
// **파라메트리 서치 유형
// 원하는 조건을 만족하는 가장 큰 값을 찾는 문제

import java.util.Arrays;
import java.util.Scanner;

public class Ex04 {
    static int N, M;
    static int[] A;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 떡의 개수
        M = sc.nextInt();   // 요청한 떡의 길이
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
    }

    static void solution() {
        Arrays.sort(A);
        int start = 0, end = A[N - 1];
        while (start <= end) {
            int mid = (start + end) / 2;
            int total = 0;
            for (int i = 0; i < N; i++) {
                // 잘랐을 때의 떡의 양 계산
                if (A[i] > mid) {
                    total += A[i] - mid;
                }
            }
            System.out.println("start = " + start + ", end = " + end + ", mid = " + mid + ", total = " + total);
            // 떡의 양이 충분한 경우 덜 자르기 (오른쪽 부분 탐색)
            if (M <= total) {
                start = mid + 1;
            }
            // 떡의 양이 부족한 경우 더 많이 자르기 (왼쪽 부분 탐색)
            else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }

    public static void main(String[] args) {
        /*
4 6
19 15 10 17
         */
        input();
        solution();
    }
}
