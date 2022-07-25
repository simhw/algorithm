package com.codingtest.exam.thisiscodingtest.ch10;

// 예제 10-8 도시 분할 계획
// <해결>
// 최소 신장 트리 2 개를 만들기 위해 트리를 구성하는 간선 중에서 가장 비용이 큰 간선을 제거

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ex06 {
    static int N, M;
    static int[][] edges;
    static int[] parent;

    static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 집의 개수
        M = sc.nextInt();   // 길의 개수
        edges = new int[M][3];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = cost;
        }
        sc.close();
        parent = new int[N + 1];

        // 부모를 자기 자신으로 초기화
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        // 간선을 비용순으로 정렬
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        // 최소 신장 트리에 포함되는 간선 중 가장 비용이 큰 간선
        int max = 0;
        int result = 0;
        // 간선을 하나씩 확인하며
        for (int i = 0; i < M; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int cost = edges[i][2];

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) == findParent(b)) {
                continue;
            } else {
                unionParent(a, b);
                result += cost;
                // 비용이 낮은 순으로 노드를 집합에 포함
                max = cost;
            }
        }
        System.out.println(result - max);
    }

    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        /*
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
         */
        solution();
    }
}
