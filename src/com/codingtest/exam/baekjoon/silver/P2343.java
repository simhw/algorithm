package com.codingtest.exam.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 기타 레슨
 * https://www.acmicpc.net/problem/2343
 */

public class P2343 {
    static int N, M;  // 강의의 수, 블루레이의 수
    static int[] lessons;

    public static int solution() {
        // 최솟값은 가장 긴 길이의 강의
        int left = lessons[N - 1];
        // 최댓값은 모든 강의 길이의 합
        int right = Arrays.stream(lessons).sum();

        // 가능한 블루레이 길이 이진 탐색
        while (left <= right) {
            int mid = (left + right) / 2;

            if (recordable(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean recordable(int size) {
        int sum = 0;
        int count = 1;

        for (int lesson : lessons) {
            if (lesson > size) {
                return false;
            }
            if (sum + lesson > size) {
                // 새로운 블루레이에 현재 강의 추가
                count++;
                sum = 0;
            }
            sum += lesson;
        }

        // 필요한 블루레이 개수 확인
        return count <= M;
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        lessons = new int[N];

        for (int i = 0; i < N; i++) {
            lessons[i] = sc.nextInt();
        }

    }

    public static void main(String[] args) {
        input();
        int answer = solution();
        System.out.println(answer);
    }
}
