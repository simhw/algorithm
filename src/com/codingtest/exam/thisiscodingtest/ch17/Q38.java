package com.codingtest.exam.thisiscodingtest.ch17;

import java.util.Scanner;

// 정확한 순위 
public class Q38 {
    static int n, m;
    static int[][] adj;
    static final int INF = (int) 1e9;

    static void solution() {
        for (int k = 1; k < n + 1; k++) {
            for (int a = 1; a < n + 1; a++) {
                for (int b = 1; b < n + 1; b++) {
                    adj[a][b] = Math.min(adj[a][b], adj[a][k] + adj[k][b]);
                }
            }
        }

        int result = 0;
        // 각 학생을 번호에 따라 한 명씩 확인하며 도달 가능하진 체크
        for (int i = 1; i < n + 1; i++) {
            boolean check = true;
            for (int j = 1; j < n + 1; j++) {
                // a에서 b로 도달이 불가능하며, b에서 a로도 도달이 불가능하다면,
                // '성적 비교 결과를 알 수 없는' 경우
                if (adj[i][j] == INF && adj[j][i] == INF) {
                    check = false;
                }
            }
            if (check) {
                result += 1;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
/*
6 6
1 5
3 4
4 2
4 6
5 2
5 4
*/
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // 초기화
        adj = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    adj[i][j] = 0;
                } else {
                    adj[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a][b] = 0;
        }
        solution();
        sc.close();
    }
}
