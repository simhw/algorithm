package com.codingtest.exam.thisiscodingtest.ch09;

import java.util.*;

public class Re09 {
    // 다익스트라 알고리즘
    static void ex01() {
        int n = 6;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());

        graph.get(1).add(new int[] { 2, 2 });
        graph.get(1).add(new int[] { 3, 5 });
        graph.get(1).add(new int[] { 4, 1 });

        graph.get(2).add(new int[] { 3, 3 });
        graph.get(2).add(new int[] { 4, 2 });

        graph.get(3).add(new int[] { 2, 3 });
        graph.get(3).add(new int[] { 6, 5 });

        graph.get(4).add(new int[] { 3, 3 });
        graph.get(4).add(new int[] { 5, 1 });

        graph.get(5).add(new int[] { 3, 1 });
        graph.get(5).add(new int[] { 6, 2 });

        int[] distance = new int[n + 1];
        Arrays.fill(distance, (int) 1e9);
        distance[1] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        queue.add(new int[] { 1, 0 });

        while (!queue.isEmpty()) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            int[] now = queue.poll();
            int node = now[0];
            int edge = now[1];

            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (distance[node] < edge) {
                continue;
            }

            // 현재 노드의 주변 노드를 확인
            for (int i = 0; i < graph.get(node).size(); i++) {
                int[] adj = graph.get(node).get(i);
                int cost = edge + adj[1];
                // 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < distance[adj[0]]) {
                    distance[adj[0]] = cost;
                    queue.add(new int[] { adj[0], cost });
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }

    // 플로이드 워셜 알고리즘
    static void ex02() {
        int n = 4;
        int INF = (int) 1e9;

        int[][] graph = {
                { INF, INF, INF, INF, INF },
                { INF, 0, 4, INF, 6 },
                { INF, 3, 0, 7, INF },
                { INF, 5, INF, 0, 4 },
                { INF, INF, INF, 2, 0 }
        };

        for (int k = 1; k < n + 1; k++) {
            for (int a = 1; a < n + 1; a++) {
                for (int b = 1; b < n + 1; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 미래 도시
    static void ex03() {
        int INF = (int) 1e9;
        int n = 5, x = 4, k = 5;

        int[][] graph = {
                { INF, INF, INF, INF, INF, INF },
                { INF, 0, 1, 1, 1, INF },
                { INF, 1, 0, INF, 1, INF },
                { INF, 1, INF, 0, 1, 1 },
                { INF, INF, 1, 1, 0, 1 },
                { INF, INF, INF, 1, 1, 0 }
        };

        for (int i = 1; i < n + 1; i++) {
            for (int a = 1; a < n + 1; a++) {
                for (int b = 1; b < n + 1; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        int dist = graph[1][k] + graph[k][x];
        if (dist >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(dist);
        }
    }

    // 전보
    static void ex04() {
        int n = 3, c = 1;

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
        graph.get(1).add(new int[] { 2, 4 });
        graph.get(1).add(new int[] { 3, 2 });

        int[] distance = new int[n + 1];
        Arrays.fill(distance, (int) 1e9);
        distance[c] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        queue.add(new int[] { c, 0 });

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (distance[now[0]] < now[1]) {
                continue;
            }

            for (int i = 0; i < graph.get(now[0]).size(); i++) {
                int[] adj = graph.get(now[0]).get(i);
                int cost = now[1] + adj[1];
                if (cost < distance[adj[0]]) {
                    distance[adj[0]] = cost;
                    queue.add(new int[] { adj[0], cost });
                }
            }
        }

        // 도달할 수 있는 노드의 개수
        int cnt = 0;
        // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            if (distance[i] < (int) 1e9 && distance[i] > 0) {
                cnt += 1;
                max = Math.max(max, distance[i]);
            }
        }
        System.out.println(cnt + " " + max);
    }

    public static void main(String[] args) {
        // ex01();
        // ex02();
        // ex03();
        // ex04();
    }
}
