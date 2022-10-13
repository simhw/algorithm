package com.codingtest.exam.thisiscodingtest.ch10;

import java.util.*;

public class Re10 {
    static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    // 서로소 집합
    static void ex01() {
        int v = 6, e = 4;
        int[][] edges = {
                { 1, 4 },
                { 2, 3 },
                { 2, 4 },
                { 5, 6 }
        };

        // 부모를 자기 자신으로 초기화
        int[] parent = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parent[i] = i;
        }

        // union 연산 수행
        for (int i = 0; i < e; i++) {
            union(parent, edges[i][0], edges[i][1]);
        }

        // 각 원소가 속한 집합 출력
        for (int i = 1; i < v + 1; i++) {
            System.out.print(find(parent, i) + " ");
        }
    }

    // 사이클 판별
    static void ex02() {
        int v = 3, e = 3;
        int[][] edges = {
                { 1, 2 },
                { 1, 3 },
                { 2, 3 }
        };

        int[] parent = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parent[i] = i;
        }

        boolean cycle = false;
        for (int i = 0; i < e; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (find(parent, a) != find(parent, b)) {
                union(parent, a, b);
            } else {
                cycle = true;
                break;
            }
        }

        if (cycle) {
            System.out.println("사이클이 발생했습니다.");
        } else {
            System.out.println("사이클이 발생하지 않았습니다.");
        }
    }

    // 크루스칼 알고리즘
    static void ex03() {
        int v = 7, e = 9;
        int[][] edges = {
                { 1, 2, 29 },
                { 1, 5, 75 },
                { 2, 3, 35 },
                { 2, 6, 34 },
                { 3, 4, 7 },
                { 4, 6, 23 },
                { 4, 7, 13 },
                { 5, 6, 53 },
                { 6, 7, 25 }
        };

        int[] parent = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parent[i] = i;
        }

        // 간선을 비용이 낮은 순으로 정렬
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int total = 0;
        for (int i = 0; i < e; i++) {
            int[] edge = edges[i];
            if (find(parent, edge[0]) != find(parent, edge[1])) {
                union(parent, edge[0], edge[1]);
                total += edge[2];
            }
        }
        System.out.println(total);
    }

    // 위상 정렬
    static void ex04() {
        int v = 7, e = 8;
        int[][] graph = {
                { 1, 2 },
                { 1, 5 },
                { 2, 3 },
                { 2, 6 },
                { 3, 4 },
                { 4, 7 },
                { 5, 6 },
                { 6, 4 }
        };

        int[] indegree = new int[v + 1];
        ArrayList<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = graph[i][0];
            int b = graph[i][1];
            edges.get(a).add(b);
            indegree[b] += 1;
        }

        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            result.add(queue.peek());
            for (Integer adj : edges.get(queue.poll())) {
                indegree[adj] -= 1;
                if (indegree[adj] == 0) {
                    queue.add(adj);
                }
            }
        }
        System.out.println(result);
    }

    // 팀 결성
    static void ex05() {
        int n = 7, m = 8;
        int[][] ops = {
                { 0, 1, 3 },
                { 1, 1, 7 },
                { 0, 7, 6 },
                { 1, 7, 1 },
                { 0, 3, 7 },
                { 0, 4, 2 },
                { 0, 1, 1 },
                { 1, 1, 1 }
        };

        int[] parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int[] op = ops[i];
            if (op[0] == 0) {
                // 팀 합치기
                union(parent, op[1], op[2]);
            } else if (op[0] == 1) {
                // 같은 팀 여부 확인
                if (find(parent, op[1]) == find(parent, op[2])) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    // 도시 분할 계획
    static void ex06() {
        int n = 7, m = 12;
        int[][] edges = {
                { 1, 2, 3 },
                { 1, 3, 2 },
                { 3, 2, 1 },
                { 2, 5, 2 },
                { 3, 4, 4 },
                { 7, 3, 6 },
                { 5, 1, 5 },
                { 1, 6, 2 },
                { 6, 4, 1 },
                { 6, 5, 3 },
                { 4, 5, 3 },
                { 6, 7, 4 }
        };

        int[] parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        // 간선을 비용이 낮은 순으로 정렬
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int total = 0, max = 0;
        for (int i = 0; i < m; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int cost = edges[i][2];

            if (find(parent, a) != find(parent, b)) {
                System.out.println(a + ", " + b + ", " + cost);
                union(parent, a, b);
                total += cost;
                max = cost;
            }
        }
        System.out.println(total - max);
    }

    // 커리큘럼
    static void ex07() {
        int n = 5;
        int[][] info = {
                { 10, -1 },
                { 10, 1, -1 },
                { 4, 1, -1 },
                { 4, 3, 1, -1 },
                { 3, 3, -1 }
        };

        ArrayList<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            edges.add(new ArrayList<>());
        }

        int[] indegree = new int[n + 1];
        int[] time = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int edge = i + 1;
            time[edge] = info[i][0];
            for (int j = 1; j < info[i].length - 1; j++) {
                indegree[edge] += 1;
                edges.get(info[i][j]).add(edge);
            }
        }

        int[] result = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            result[i] = time[i];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Integer adj : edges.get(now)) {
                result[adj] = Math.max(result[adj], result[now] + time[adj]);
                indegree[adj] -= 1;
                if (indegree[adj] == 0) {
                    queue.add(adj);
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        // ex01();
        // ex02();
        // ex03();
        // ex04();

        // ex05();
        // ex06();
        ex07();
    }
}
