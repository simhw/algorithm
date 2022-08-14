package com.codingtest.exam.thisiscodingtest.ch17;

import java.util.*;

// 플로이드 
public class Q37 {
    static int n, m;
    static int[][] adj;
    static final int INF = (int) 1e9;

    // 플로이드 워셜 알고리즘
    static void solution() {
        for (int k = 1; k < n + 1; k++) {
            for (int a = 1; a < n + 1; a++) {
                for (int b = 1; b < n + 1; b++) {
                    adj[a][b] = Math.min(adj[a][b], adj[a][k] + adj[k][b]);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (adj[i][j] == INF) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(adj[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // 초기화
        adj = new int[n + 1][n + 1];

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(adj[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    adj[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // 가장 짧은 간선 정보만 저장
            adj[a][b] = Math.min(adj[a][b], c);
        }
        solution();
        sc.close();
    }
}
