package com.codingtest.exam.thisiscodingtest.ch17;

import java.util.*;

// 화성 탐사
public class Q39 {
    static int t;
    static int n;
    static int[][] arr;

    static void solution() {
        final int INF = (int) 1e9;

        // 상, 하, 좌, 우
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        int[][] distance = new int[n][n];
        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], INF);
        }

        // 시작 노드 큐에 삽입
        int x = 0, y = 0;
        int dist = arr[x][y];

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(x, y, dist));
        distance[x][y] = dist;

        // 다익스트라 알고리즘
        while (!queue.isEmpty()) {
            /// 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = queue.poll();
            x = node.x;
            y = node.y;
            dist = node.distance;

            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (distance[x][y] < dist)
                continue;

            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 그래프 범위를 벗어나는 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;

                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우 큐에 삽입
                int cost = dist + arr[nx][ny];
                if (distance[nx][ny] > cost) {
                    distance[nx][ny] = cost;
                    queue.add(new Node(nx, ny, cost));
                }
            }
        }
        System.out.println(distance[n - 1][n - 1]);
    }

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n][n];

        for (int tc = 0; tc < t; tc++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            solution();
        }
        sc.close();

        // n = 3;
        // arr = new int[][] {
        // { 5, 5, 4 },
        // { 3, 9, 1 },
        // { 3, 2, 7 } };
        solution();
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int distance;

    Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
    }

    public String toString() {
        return "{x:" + this.x + " ,y:" + this.y + ",distance:" + this.distance + "}";
    }
}
