package com.codingtest.exam.thisiscodingtest.ch05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 예제 5-11 미로 탈출

public class Ex07 {
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

    static void solution(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        graph[x][y] = 1;

        // 상, 하, 좌, 우 방향 정의
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        int nx, ny = 0;
        int[] coordinate;
        while (!queue.isEmpty()) {
            coordinate = queue.poll();
            x = coordinate[0]; y = coordinate[1];
            // 현재 위치에서 네 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) {
                    continue;
                }
                // 괴물이 있는 경우 무시
                if (graph[nx][ny] == 0) {
                    continue;
                }
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 등록
                if (graph[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny});
                    // 이전 노드의 거리에 1 을 더한 값을 등록
                    graph[nx][ny] = graph[x][y] + 1;
                }
            }
        }
        System.out.println(graph[N - 1][M - 1]);
    }
    public static void main(String[] args) {
        /*
5 6
1 0 1 0 1 0
1 1 1 1 1 1
0 0 0 0 0 1
1 1 1 1 1 1
1 1 1 1 1 1
         */
        input();
        solution(0, 0);
    }
}
