package com.codingtest.exam.thisiscodingtest.ch05;

// 예제 5-10 음료수 얼려 먹기

// <해결>
// 1. 특정한 지점의 주변 상, 하, 좌, 우를 살펴본 뒤에 주변 지점 중에서 값이 '0' 이면서
// 아직 방문하지 않은 지점이 있다면 해당 지점을 방문한다.
// 2. 방문한 지점에서 다시 상, 하, 좌, 우를 살펴보면서 다시 진행하면, 연결된 모든 지점을 방문할 수 있다.
// 3. 1 ~ 2 번의 과정을 모든 노드에 반복하며 방문하지 않은 지점의 수를 센다.

import java.util.Scanner;

public class Ex06 {
    static int N, M;
    static int[][] graph;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    // DFS 로 특정한 노드를 방문한 뒤에 연결된 모든 노드들도 방문
    static boolean dfs(int x, int y) {
        // 상, 하, 좌, 우 방향 정의
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        // 주어진 범위를 벗어나는 경우 즉시 종료
        if (x < 0 || x > N - 1 || y < 0 || y > M - 1) {
            return false;
        }

        // 현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {
            // 해당 노드 방문 처리
            graph[x][y] = 1;

            // 상, 하, 좌, 우 위치도 모두 재귀 호출
            for (int i = 0; i < 4; i++) {
                dfs(x + dx[i], y + dy[i]);
            }
            return true;
        } else {
            return false;
        }
    }

    static void solution() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1) { // 칸막이
                    continue;
                } else {
                    if (dfs(i, j)) {
                        result += 1;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        /*
4 5
0 0 1 1 0
0 0 0 1 1
1 1 1 1 1
0 0 0 0 0
        */
        input();
        solution();
    }
}
