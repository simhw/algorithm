package com.codingtest.exam.thisiscodingtest.ch17;

import java.util.*;

// 숨바꼭질 
public class Q40 {
    static int n, m;
    static List<List<Integer>> graph;

    static void solution() {
        final int INF = (int) 1e9;
        int[] distance = new int[n + 1];
        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(distance, INF);

        Queue<Integer> queue = new LinkedList<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        queue.add(1);
        distance[1] = 0;

        // 다익스트라 알고리즘
        while (!queue.isEmpty()) {
            int node = queue.poll();
            // 현재 노드와 인접한 모든 노드 방문
            for (int adj : graph.get(node)) {
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우 큐에 삽입
                int cost = distance[node] + 1;
                if (distance[adj] > cost) {
                    distance[adj] = cost;
                    queue.add(adj);
                }
            }
        }

        // 최단 거리가 가장 먼 노드 번호
        int index = 0;
        // 도달할 수 있는 노드 중에서, 최단 거리가 가장 먼 노드와의 최단 거리
        int max = 0;
        // 최단 거리가 가장 먼 노드의 개수
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (max < distance[i]) {
                index = i;
                max = distance[i];
                count = 1;
            } else if (max == distance[i]) {
                count += 1;
            }
        }
        System.out.println(index + " " + max + " " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // a번 노드와 b번 노드의 이동 비용이 1이라는 의미(양방향)
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        solution();
        sc.close();
    }
}
