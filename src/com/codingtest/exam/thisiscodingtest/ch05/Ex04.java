package com.codingtest.exam.thisiscodingtest.ch05;

// DFS

public class Ex04 {
    static void dfs(int[][] graph, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < graph[v].length; i++) {
            if (visited[graph[v][i]] == false) {
                dfs(graph, graph[v][i], visited);
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
        dfs(graph, 1, visited);
    }
}
