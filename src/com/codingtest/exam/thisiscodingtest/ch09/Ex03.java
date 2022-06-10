package com.codingtest.exam.thisiscodingtest.ch09;

// 플로이드 워셜 알고리즘 
// 모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구해야 하는 경우 

public class Ex03 {
    static int N;
    static int[][] graph;

    static void input() {
        N = 4;

        // 2 차원 배열, 모든 값을 무한으로 초기화
        graph = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                graph[i][j] = (int) 1e9;
            }
        }
        // A 에서 B 로 가는 비용 C 설정
        graph[1][2] = 4;
        graph[1][4] = 6;
        graph[2][1] = 3;
        graph[2][3] = 7;
        graph[3][1] = 5;
        graph[3][4] = 4;
        graph[4][3] = 2;
    }

    static void solution() {
        // 자기 자신에서 자기 자신으로 가는 비용은 0 으로 초기화
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == j)
                    graph[i][j] = 0;
            }
        }

        // 거쳐 가는 노드 선택
        for (int i = 1; i < N + 1; i++) {
            // 출발 노드 선택
            for (int j = 1; j < N + 1; j++) {
                if (i == j)
                    continue; // 자기 자신으로 가는 비용은 0 이므로 무시
                // 도착 노드 선택
                for (int k = 1; k < N + 1; k++) {
                    if (j == k)
                        continue; // 자기 자신으로 가는 비용은 0 이므로 무시
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
