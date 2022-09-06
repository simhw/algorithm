package com.codingtest.exam.thisiscodingtest.ch19;

import java.util.*;

// 아기 상어 
// 매번 현재 위치에서 도달 가능한 다른 모든 위치까지의 최단 거리를 구한 뒤, 먹을 물고기의 위치를 찾는 과정을 반복 
public class Ex46 {
    static int n;
    static int[][] graph;

    // 좌, 하, 우, 상으로 인접한 한 칸씩 이동
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int size = 2;

    // 모든 위치까지의 '최단 거리만' 계산하는 함수
    static int[][] bfs(int x, int y) {
        // 값이 -1이라면 도달할 수 없다는 의미(초기화)
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        // 시작 위치는 도달이 가능하다고 보며 거리는 0
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(x, y));
        dist[x][y] = 0;

        while (!queue.isEmpty()) {
            List<Integer> now = queue.poll();
            x = now.get(0);
            y = now.get(1);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    // 자신의 크기보다 작거나 같은 경우에만 지나갈 수 있음
                    if (dist[nx][ny] == -1 && graph[nx][ny] <= size) {
                        dist[nx][ny] = dist[x][y] + 1;
                        queue.add(new LinkedList<>(Arrays.asList(nx, ny)));
                    }
                }
            }
        }
        // 모든 위치까지의 최단 거리 테이블 반환
        return dist;
    }

    // 최단 거리 테이블이 주어졌을 때, 먹을 물고기를 찾는 함수
    static int[] find(int[][] dist) {
        int[] value = new int[3];
        int min = (int) 1e9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 도달이 가능하면서 먹을 수 있는 물고기일 때
                if (dist[i][j] != -1 && graph[i][j] >= 1 && graph[i][j] < size) {
                    // 가장 가까운 물고기 한 마리만 선택
                    if (dist[i][j] < min) {
                        value[0] = i;
                        value[1] = j;
                        min = dist[i][j];
                    }
                }
            }
        }
        // 먹을 수 있는 물고기가 없는 경우
        if (min == (int) 1e9) {
            return new int[0];
        } else {
            value[2] = min;
            return value;
        }
    }

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // 아기 상어의 현재 위치 변수
        int x = 0, y = 0;

        // 아기 상어의 시작 위치를 찾은 뒤, 그 위치에 방문 처리
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 9) {
                    x = i;
                    y = j;
                    graph[x][y] = 0;
                }
            }
        }

        int answer = 0;
        int ate = 0;

        while (true) {
            // 먹을 수 있는 물고기 위치 찾기
            int[] value = find(bfs(x, y));
            // 먹을 수 있는 물고기가 없을 경우, 현재까지 움직인 거리 출력
            if (value.length == 0) {
                System.out.println(answer);
                break;
            } else {
                // 현재 위치 갱신 및 이동 거리 변경
                x = value[0];
                y = value[1];
                answer += value[2];

                // 먹은 위치에는 이제 아무것도 없도록 처리
                graph[x][y] = 0;
                ate += 1;
                // 자신의 현재 크기 이상으로 먹은 경우, 크기 증가
                if (ate >= size) {
                    size += 1;
                    ate = 0;
                }
            }
        }
        sc.close();
    }
}
