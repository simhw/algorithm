package com.codingtest.exam.thisiscodingtest.ch18;

import java.util.*;

// 어두운 길 
public class Q43 {
    static int n, m;
    static Queue<Node> graph;

    // 최소 신장 트리 알고리즘
    static void solution() {
        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int total = 0;
        int result = 0;
        while (!graph.isEmpty()) {
            Node node = graph.poll();
            total += node.d;
            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (find(parent, node.x) != find(parent, node.y)) {
                union(parent, node.x, node.y);
                result += node.d;
            }
        }
        System.out.println(total - result);
    }

    static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph.add(new Node(x, y, z));
        }
        solution();
        sc.close();
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int d;

    Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        // 간선 데이터를 비용에 따라 오름차순 정렬
        return this.d - o.d;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "{x:" + x + ", y;" + y + ", d:" + d + "}";
    }
}
