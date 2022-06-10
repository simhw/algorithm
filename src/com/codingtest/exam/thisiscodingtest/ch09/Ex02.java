package com.codingtest.exam.thisiscodingtest.ch09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// 개선된 다익스트라 알고리즘 

// 최단 거리가 가장 짧은 노드를 선택하는 과정을 다익스트라 최단 경로 함수 안에서 
// 우선순위 큐를 이용하는 방식으로 대체 

public class Ex02 {
    static int N, M;
    static int start;
    static ArrayList<Node>[] graph;
    static int[] distance;
    static PriorityQueue<Node> queue;

    static void input() {
        N = 6;
        M = 11;
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

        queue = new PriorityQueue<>();
    }

    static void solution() {
        distance = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        dijkstra();
    }

    static void dijkstra() {
        // 시작 노드로 가기 위한 최단 경로는 0 으로 설정하여, 큐에 삽입 
        queue.add(new Node(start, 0));
        distance[start] = 0;

        while (!queue.isEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기 
            System.out.println(queue.toString());
            Node node = queue.poll();
            // 현재 노드가 이미 처리된 적이 있다면 무시 
            if (distance[node.vertex] < node.edge) {
                continue;
            } else {
                // 현재 노드와 연결된 다른 인접한 노드들을 확인 
                for (Node adjacent : graph[node.vertex]) {
                    int cost = node.edge + adjacent.edge;
                    // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우 
                    if (distance[adjacent.vertex] > cost) {
                        distance[adjacent.vertex] = cost;
                        queue.add(new Node(adjacent.vertex, cost));
                    }
                }
                System.out.println(Arrays.toString(distance));
            }
        }
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}