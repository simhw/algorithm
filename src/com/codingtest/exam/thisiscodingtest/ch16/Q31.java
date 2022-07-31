package com.codingtest.exam.thisiscodingtest.ch16;

import java.util.Scanner;

// 금광 
// 보터업
// 반복문을 이용해 작은 문제를 먼저 해결하고, 해결된 작은 문제를 모아 큰 문제를 해결 
public class Q31 {
    static int t, n, m;

    static int[][] arr;
    static int[][] dp;

    static int[] dx = { -1, 0, 1 };
    static int[] dy = { 1, 1, 1 };

    static int answer = 0;

    static void solution() {
        // 다이나믹 프로그래밍을 위한 2차원 dp 테이블 초기화
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = arr[i][j];
            }
        }

        // 다이나믹 프로그래밍 진행
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int leftUp, leftDown, left;
                // 왼쪽 위에서 오는 경우
                if (i == 0)
                    leftUp = 0;
                else
                    leftUp = dp[i - 1][j - 1];
                // 왼쪽 아래에서 오는 경우
                if (i == n - 1)
                    leftDown = 0;
                else
                    leftDown = dp[i + 1][j - 1];
                // 왼쪽에서 오는 경우
                left = dp[i][j - 1];
                dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i][m - 1]);
        }
        System.out.println(result);
    }

    static void mysolution(int x, int y, int k, int result) {
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            mysolution(nx, ny, k += 1, result += arr[nx][ny]);
            result -= arr[nx][ny];
            k -= 1;
        }
        // m번 이동 후 금의 최대 크기 비교
        if (k == m) {
            answer = Math.max(answer, result);
        }
    }

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[n][m] = sc.nextInt();
                }
            }
            solution();
        }
        sc.close();
    }
}
