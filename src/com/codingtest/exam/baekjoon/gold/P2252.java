package com.codingtest.exam.baekjoon.gold;

import java.util.*;

/**
 * 줄 세우기
 * https://www.acmicpc.net/problem/2252
 */
public class P2252 {
    static int n;
    static int m;
    static int[][] compare;

    public static void solution() {
        List<Integer> answer = new ArrayList<>();

        int[] indegree = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : compare) {
            // a가 b의 앞에 서야함
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            // 진입차수 증가
            indegree[b]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 진입차수가 0인 노드를 최소 힙에 추가
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        // 위상 정렬 수행
        while (!pq.isEmpty()) {
            int now = pq.poll();
            answer.add(now);

            // 현재 노드의 인접한 노드 확인
            for (int next : graph.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        compare = new int[m][2];

        for (int i = 0; i < m; i++) {
            compare[i][0] = sc.nextInt();
            compare[i][1] = sc.nextInt();
        }

        solution();
        sc.close();
    }
}
