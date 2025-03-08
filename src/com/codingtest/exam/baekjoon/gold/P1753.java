package com.codingtest.exam.baekjoon.gold;

import java.util.*;

/**
 * 최단경로
 * https://www.acmicpc.net/problem/1753
 */
public class P1753 {
    public static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        // 가중치가 작은 노드가 높은 우선순위를 가짐
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int v, e, k;
    static ArrayList<ArrayList<Node>> graph;

    public static void solution() {
        int[] distance = new int[v + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 시작 노드 초기화
        distance[k] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            // 현재 노드의 최단 거리가 이미 더 짧은 경우 생략
            if (distance[now.vertex] < now.weight) {
                continue;
            }

            for (Node adj : graph.get(now.vertex)) {
                // 현재 노드를 거쳐서 인접 노드로 이동하는 거리
                int cost = distance[now.vertex] + adj.weight;

                if (cost < distance[adj.vertex]) {
                    distance[adj.vertex] = cost;
                    pq.offer(new Node(adj.vertex, cost));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        k = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            // u에서 v로 가는 가중치 w인 간선
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Node(v, w));
        }

        solution();
        sc.close();
    }
}
