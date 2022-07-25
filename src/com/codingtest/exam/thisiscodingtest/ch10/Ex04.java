package com.codingtest.exam.thisiscodingtest.ch10;

// 위상 정렬
// 방향 그래프의 모든 노드를 방향성에 거스르지 않도록 순서대로 나열하는 것

// 1. 진입차수가 0 인 노드를 큐에 넣는다.
// 2. 큐가 빌 때까지 다음의 과정을 반복한다.
// 2-1. 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거한다.
// 2-2. 새롭게 진입차수가 0 이 된 노드를 큐에 넣는다.

import java.util.*;

public class Ex04 {
    static int V, E;
    static int indegree[];
    static ArrayList<Integer>[] graph;

    static void solution() {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        // 모든 노드에 대한 진입차수는 0 으로 초기화
        indegree = new int[V + 1];
        // 각 노드에 연결된 간선 정보를 담기 위한 그래프 초기화
        for (int i = 1; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 정점 A 에서 B 로 이동 가능
            graph[a].add(b);
            // 진입차수를 1 증가
            indegree[b] += 1;
        }
        sc.close();
        topology();
    }

    static void topology() {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // 처음 시작할 때는 진입차수가 0 인 노드를 큐에 삽입
        for (int i = 1; i < V + 1; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);
            // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (int adj : graph[now]) {
                indegree[adj] -= 1;
                // 새롭게 진입차수가 0 이 되는 노드를 큐에 삽입
                if (indegree[adj] == 0) {
                    queue.add(adj);
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        solution();
    }
}