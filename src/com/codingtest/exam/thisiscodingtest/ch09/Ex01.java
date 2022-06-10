package com.codingtest.exam.thisiscodingtest.ch09;

// 다익스트라 최단 경로 알고리즘

import java.util.ArrayList;
import java.util.Arrays;

public class Ex01 {

    static int N, M;
    static int start;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] distance;

    static void input() {
        N = 6;   // 노드의 개수
        M = 11;   // 간선의 개수
        start = 1;
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[1].add(new Node(2, 2));
        graph[1].add(new Node(3, 5));
        graph[1].add(new Node(4, 1));
        graph[2].add(new Node(3, 3));
        graph[2].add(new Node(4, 2));
        graph[3].add(new Node(2, 3));
        graph[3].add(new Node(6, 5));
        graph[4].add(new Node(3, 3));
        graph[4].add(new Node(5, 1));
        graph[5].add(new Node(3, 1));
        graph[5].add(new Node(6, 2));
    }

    static void solution() {
        visited = new boolean[N + 1];
        // 최단 거리 테이블을 모두 무한으로 초기화
        distance = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            if (i == start) {
                continue;
            }
            distance[i] = Integer.MAX_VALUE;
        }
        // 다익스트라 알고리즘 수행
        dijkstra();
    }

    //  방문하지 않은 노드 중에, 가장 최단 거리가 짧은 노드 번호 반환
    static int getSmallestNode() {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 1; i < N + 1; i++) {
            if (distance[i] < min && visited[i] == false) {
                min = distance[i];
                index = i;
            }
        }
        System.out.println("next = " + index);
        return index;
    }

    static void dijkstra() {
        // 시작 노드 방문 및 초기화
        visited[start] = true;
        for (Node node : graph[start]) {
            distance[node.vertex] = node.edge;
        }
        System.out.println(Arrays.toString(distance));

        // 시작 노드를 제외한 전체 N - 1 개의 노드에 대해 반복
        for (int i = 0; i < N - 1; i++) {
            int now = getSmallestNode();
            visited[now] = true;
            // 현재 노드와 연결된 다른 노드 확인
            for (Node node : graph[now]) {
                int cost = distance[now] + node.edge;
                // 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경우
                distance[node.vertex] = Math.min(distance[node.vertex], cost);
            }
            System.out.println(Arrays.toString(distance));
        }
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
