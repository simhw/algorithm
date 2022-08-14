package com.codingtest.exam.thisiscodingtest.ch09;

import java.util.ArrayList;

// 다익스트라 최단 경로 알고리즘
public class Ex01 {
    static int n, m;
    static int start;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;
    static int[] distance;

    static void input() {
        n = 6; // 노드의 개수
        m = 11; // 간선의 개수
        start = 1;
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph = new ArrayList<>();
        }
        graph.get(1).add(new Node(2, 2));
        graph.get(1).add(new Node(3, 5));
        graph.get(1).add(new Node(4, 1));
        graph.get(2).add(new Node(3, 3));
        graph.get(2).add(new Node(4, 2));
        graph.get(3).add(new Node(2, 3));
        graph.get(3).add(new Node(6, 5));
        graph.get(4).add(new Node(3, 3));
        graph.get(4).add(new Node(5, 1));
        graph.get(5).add(new Node(3, 1));
        graph.get(5).add(new Node(6, 2));
    }

    static void solution() {
        visited = new boolean[n + 1];
        // 최단 거리 테이블을 모두 무한으로 초기화
        distance = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (i == start) {
                continue;
            }
            distance[i] = Integer.MAX_VALUE;
        }
        // 다익스트라 알고리즘 수행
        // 시작 노드 방문 및 초기화
        visited[start] = true;
        for (Node node : graph.get(start)) {
            distance[node.vertex] = node.edge;
        }

        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            int now = getSmallestNode();
            visited[now] = true;
            // 현재 노드와 연결된 다른 노드 확인
            for (Node node : graph.get(now)) {
                int cost = distance[now] + node.edge;
                // 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경우
                distance[node.vertex] = Math.min(distance[node.vertex], cost);
            }
        }
    }

    // 방문하지 않은 노드 중에, 가장 최단 거리가 짧은 노드 번호 반환
    static int getSmallestNode() {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 1; i < n + 1; i++) {
            if (distance[i] < min && visited[i] == false) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
