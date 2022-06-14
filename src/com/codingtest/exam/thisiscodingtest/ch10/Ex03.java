package com.codingtest.exam.thisiscodingtest.ch10;

// 신장 트리 (크루스칼 알고리즘)
// 하나의 그래프가 있을 때 모든 모드를 포함하면서 사이클이 존재하지 않는 부분 그래프

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ex03 {
    static int V, E;
    static int[][] edges;
    static int[] parent;

    static void solution() {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        parent = new int[V + 1];
        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }
        edges = new int[E][3];

        // 모든 간선에 대한 정보를 입력받기
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges[a][b] = cost;
        }

        // 간선을 비용순으로 정렬
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int result = 0;

        // 간선을 하나씩 확인하며
        for (int i = 0; i < E; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int cost = edges[i][2];
            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }

        System.out.println(result);
    }

    static int findParent(int x) {
        if (x != parent[x]) {
            // 함수를 재귀적으로 호출한 뒤 부모 테이블 값을 갱신
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
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

    public static void main(String[] args) {
        solution();
    }
}
