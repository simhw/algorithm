package com.codingtest.exam.thisiscodingtest.ch13;

import java.util.*;

// 연구소
public class Q16 {
    static int n, m, result = 0;
    static int[][] graph;
    static int[][] selected;

    // 4가지 이동 방향에 대한 배열
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 깊이 우선 탐색(DFS)을 이용해 각 바이러스가 사방으로 퍼지도록 하기
    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 상, 하, 좌, 우 중에서 바이러스가 퍼질 수 있는 경우
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (selected[nx][ny] == 0) {
                    // 해당 위치에 바이러스 배치하고, 다시 재귀적으로 수행
                    selected[nx][ny] = 2;
                    dfs(nx, ny);
                }
            }
        }
    }

    // 너비 우선 탐색(BFS)을 이용해 각 바이러스가 사방으로 퍼지도록 하기
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (selected[nx][ny] == 0) {
                        // 해당 위치에 바이러스 배치하고, 다시 재귀적으로 수행
                        selected[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }


    // 현재 맵에서 안전 영역의 크기 계산하는 메서드
    static int score() {
        int score = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (selected[i][j] == 0) {
                    score += 1;
                }
            }
        }
        return score;
    }

    // 깊이 우선 탐색(DFS)을 이용해 울타리를 설치하면서, 매 번 안전 영역의 크기 계산
    static void combination(int k) {
        // 울타리가 3개 설치된 경우
        if (k == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    selected[i][j] = graph[i][j];
                }
            }

            // 각 바이러스의 위치에서 전파 진행
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (selected[i][j] == 2) {
                        bfs(i, j);
                    }
                }
            }
            // 안전 영역의 최대값 계산
            result = Math.max(result, score());
            return;
        }
        // 빈 공간에 울타리를 설치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    combination(k + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n][m];
        selected = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        sc.close();

        combination(0);
        System.out.println(result);
    }
}
