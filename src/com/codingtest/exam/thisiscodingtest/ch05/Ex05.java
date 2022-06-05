package com.codingtest.exam.thisiscodingtest.ch05;

import java.util.LinkedList;
import java.util.Queue;

// BFS
public class Ex05 {
    static void bfs(int[][] graph, int v, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        // 현재 노드 방문 처리
        visited[v] = true;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 하나의 원소를 뽑아 출력
            v = queue.poll();
            System.out.print(v + " ");
            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for (int i = 0; i < graph[v].length; i++) {
                if (visited[graph[v][i]] == false) {
                    queue.add(graph[v][i]);
                    visited[graph[v][i]] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}
        };

        boolean[] visited = new boolean[9];
        bfs(graph, 1, visited);
    }
}
