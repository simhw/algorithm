package com.codingtest.exam.thisiscodingtest.ch13;

import java.util.*;

// 특정 거리의 도시 찾기
public class Q15 {
    static int N, M, K, X;
    static List<List<Integer>> graph;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 도시의 개수
        M = sc.nextInt();   // 도로의 개수
        K = sc.nextInt();   // 거리 정보
        X = sc.nextInt();   // 도시 번호

        graph = new ArrayList<>(N + 1);

        for (int i = 0; i < N + 1; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
    }

    static void solution() {
        int[] distance = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            distance[i] = -1;
        }
        distance[X] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            // 현재 도시에서 이동할 수 있는 모든 도시를 확인
            for (int next : graph.get(now)) {
                // 아직 방문하지 않은 도시라면
                if (distance[next] != -1) {
                    distance[next] = distance[now] + 1;
                    queue.add(next);
                }
            }
        }
    }

    static void mySolution() {
        // X 로 부터 출발하여 도달할 수 있는 도시 중, 최단 거리가 K 인 모든 도시 번호 출력
        int[] distance = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            distance[i] = 300001;
        }

        // 출발 도시까지의 최단 거리는 0 으로 설정
        distance[X] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            // 현재 도시에서 이동할 수 있는 모든 도시를 확인
            for (int next : graph.get(now)) {
                // 다익스트라 최단 경로 알고리즘
                distance[next] = Math.min(distance[next], distance[now] + 1);
                queue.add(next);
            }
        }

        boolean exist = false;
        for (int i = 1; i < N + 1; i++) {
            if (distance[i] == K) {
                System.out.println(distance[i]);
                exist = true;
            }
        }
        if (!exist) {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        /*
4 4 2 1
1 2
1 3
2 3
2 4
         */
        input();
        solution();
    }
}
