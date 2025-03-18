package com.codingtest.exam.baekjoon.gold;

import java.util.*;

/**
 * 회의실 배정
 * https://www.acmicpc.net/problem/1931
 */
public class P1931 {
    static int n;
    static List<int[]> meetings;

    public static int solution() {
        int answer = 0;
        // 끝나는 시간 기준으로 정렬, 끝나는 시간이 같으면 시작 시간 기준
        meetings.sort((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int last = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            // 회의의 시작 시간이 이전 회의의 끝나는 시간 이후인지 확인
            if (start >= last) {
                answer++;
                last = end;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings.add(new int[]{start, end});
        }

        System.out.println(solution());
        sc.close();
    }
}
