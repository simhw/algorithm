package com.codingtest.exam.thisiscodingtest.ch09;

import java.util.*;
// 예제 9-5 전보  

// <해결>
// 한 도시에서 다른 도시까지의 최단 거리 문제로 치환할 수 있으므로 
// 다익스트라 알고리즘을 이용 

public class Ex05 {
    static int n, m, c;
    static ArrayList<ArrayList<Node>> graph;

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 도시의 개수
        m = sc.nextInt(); // 통로의 개수
        c = sc.nextInt(); // 메시지를 보내는 도시

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }
        sc.close();
    }

    static void solution() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] distance = new int[n + 1];

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 1; i < n + 1; i++) {
            distance[i] = (int) 1e9;
        }

        // 시작 노드로 가기 위한 최단 경로는 0 으로 설정
        distance[c] = 0;
        queue.add(new Node(c, 0));

        while (!queue.isEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node now = queue.poll();
            // 방문한 노드인 경우 무시
            if (distance[now.vertex] < now.edge)
                continue;
            // 현재 노드와 인접한 노드 방문
            for (Node adjacent : graph.get(now.vertex)) {
                int cost = now.edge + adjacent.edge;
                // 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < distance[adjacent.vertex]) {
                    distance[adjacent.vertex] = cost;
                    queue.add(new Node(adjacent.vertex, cost));
                }
            }
        }
        // 도달할 수 있는 노드의 개수
        int count = 0;
        // 가장 멀리 있는 노드와의 최단 시간 (거리)
        int time = -1;
        for (int i = 1; i < n + 1; i++) {
            if (i == c)
                continue;
            if (distance[i] < (int) 1e9) {
                count += 1;
                time = Math.max(time, distance[i]);
            }
        }
        System.out.println(count + " " + time);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}