package com.codingtest.exam.thisiscodingtest.ch05;

import java.util.*;

public class Re05 {
    // dfs
    static void ex01() {
        int[][] graph = new int[][] {
                {},
                { 2, 3, 8 },
                { 1, 7 },
                { 1, 4, 5 },
                { 3, 5 },
                { 3, 4 },
                { 7 },
                { 2, 6, 8 },
                { 1, 7 }
        };
        boolean[] visited = new boolean[9];
        List<Integer> stack = new ArrayList<>();

        // 탐색 시작 노드를 스택에 삽입하고 방문 처리
        stack.add(1);
        visited[1] = true;

        while (!stack.isEmpty()) {
            // 스택 최상단 노드에 방문하지 않은 인접 노드 방문
            int node = stack.get(stack.size() - 1);
            for (int i = 0; i < graph[node].length; i++) {
                int adj = graph[node][i];
                if (visited[adj] == false) {
                    stack.add(adj);
                    visited[adj] = true;
                    break;
                }
                if (i == graph[node].length - 1) {
                    stack.remove(stack.size() - 1);
                }
            }
        }
    }

    // bfs
    static void ex02() {
        int[][] graph = new int[][] {
                {},
                { 2, 3, 8 },
                { 1, 7 },
                { 1, 4, 5 },
                { 3, 5 },
                { 3, 4 },
                { 7 },
                { 2, 6, 8 },
                { 1, 7 }
        };
        boolean[] visited = new boolean[9];
        Queue<Integer> queue = new LinkedList<>();

        // 탐색 시작 노드를 큐에 삽입하고 방문 처리
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            // 큐에서 노드를 꺼내 해당 노드의 인접 노드 중 방문하지 않은 노드를 모두 큐에 삽입하고 방문
            int node = queue.poll();
            for (int i = 0; i < graph[node].length; i++) {
                int adj = graph[node][i];
                if (visited[adj] == false) {
                    queue.add(adj);
                    visited[adj] = true;
                }
            }
        }
    }

    // 음료수 얼려 먹기
    static void ex03() {
        int n = 4, m = 5;
        int[][] graph = {
                { 0, 0, 1, 1, 0 },
                { 0, 0, 0, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 },
        };

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // dfs로 특정 노드를 방문한 뒤에 연결된 모든 노드들도 방문
                if (dfs(i, j, graph) == true) {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }

    static boolean dfs(int x, int y, int[][] graph) {
        if (x < 0 || x >= graph.length || y < 0 || y >= graph[0].length) {
            return false;
        }
        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            // 상, 하, 좌, 우 위치도 재귀적으로 호출
            dfs(x - 1, y, graph);
            dfs(x + 1, y, graph);
            dfs(x, y - 1, graph);
            dfs(x, y + 1, graph);
            return true;
        } else {
            return false;
        }
    }

    // 미로 탈출
    static void ex04() {
        int n = 5, m = 6;
        int[][] graph = {
                { 1, 0, 1, 0, 1, 0 },
                { 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 }
        };

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        List<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });

        while (!queue.isEmpty()) {
            int[] node = queue.remove(queue.size() - 1);
            int x = node[0];
            int y = node[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    queue.add(new int[] { nx, ny });
                }
            }
        }
        System.out.println(graph[n - 1][m - 1]);
    }

    public static void main(String[] args) {
        ex04();
    }
}
