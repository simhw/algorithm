package com.codingtest.exam.thisiscodingtest.ch16;

// 퇴사
import java.util.Scanner;

public class Q33 {
    static int n;
    static int[] t;
    static int[] p;
    static int[] dp;

    static void solution() {
        int max = 0;
        dp = new int[n + 1];

        // 뒤에서부터 거꾸로 확인
        for (int i = n - 1; i >= 0; i--) {
            int term = t[i] + i;
            // 상담이 기간 안에 끝나는 경우
            if (term <= n) {
                // '현재 상담 일자의 이윤 + 현재 상담을 마친 일자부터의 최대 이윤'
                dp[i] = Integer.max(p[i] + dp[term], max);
                max = dp[i];
            }
            // 상담이 기간을 벗어나는 경우
            else {
                dp[i] = max;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = new int[n];
        p = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        sc.close();
        solution();
    }
}
