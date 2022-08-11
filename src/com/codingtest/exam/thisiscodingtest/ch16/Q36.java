package com.codingtest.exam.thisiscodingtest.ch16;

import java.util.Scanner;

//편집 거리 
public class Q36 {
    static char[] a;
    static char[] b;
    static int[][] dp;

    static void solution() {
        // a = new char[] { 's', 'u', 'n', 'd', 'a', 'y' };
        // b = new char[] { 's', 'a', 't', 'u', 'r', 'd', 'a', 'y' };

        int n = a.length;
        int m = b.length;

        dp = new int[n + 1][m + 1];

        // dp 테이블 초기화
        // 0은 빈 문자열을 의미
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }
        // 최소 편집 거리 계산
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // 문자가 같다면, 왼쪽 위에 해당하는 수를 그대로 삽입
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 문자가 다르다면, 3가지 경우 중에서 최소값 찾기
                // 삽입(왼쪽), 삭제(위쪽), 교체(왼쪽 위) 중에서 최소 비용을 찾아 대입
                else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        System.out.println(dp[n + 1][m + 1]);
    }

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        a = str1.toCharArray();
        b = str2.toCharArray();
        sc.close();
        solution();
    }
}
