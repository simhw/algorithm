package com.codingtest.exam.thisiscodingtest.ch09;

import java.util.Scanner;

// 예제 9-4 미래 도시 

// <문제>
// 1 번 회사에서 출발하여 K 번 회사를 방문한 뒤 X 번 회사로 가는 최소 시간 

public class Ex04 {
    static int N, M;
    static int X, K;
    static int[][] graph;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 회사의 개수
        M = sc.nextInt(); // 경로의 개수

        graph = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == j) {
                    // 자기 자신에서 자기 자신으로 가는 비용은 0 으로 초기화
                    graph[i][j] = 0;
                } else {
                    // 2 차원 배열, 모든 값을 무한으로 초기화
                    graph[i][j] = (int) 1e9;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // A 와 B 가 서로에게 가는 비용은 1 로 설정 
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        X = sc.nextInt(); // 최종 목적지
        K = sc.nextInt(); // 경유지
        sc.close();
    }

    static void solution() {
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
        
        int distance = graph[1][K] + graph[K][X];

        if (distance >= (int) 1e9) {
            System.out.println("-1");
        } else {
            System.out.println(distance);
        }
    }

    public static void main(String[] args) {
        /*
5 7
1 2 1 3 1 4
2 4
3 4 3 5 4 5
4 5
         */

        input();
        solution();
    }
}
