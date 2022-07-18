package com.codingtest.exam.thisiscodingtest.ch13;

import java.util.*;

// 인구 이동  
public class Q21 {
    static int n, l, r;
    static int[][] arr;

    static boolean[][] visited;
    static boolean moved;
    static int answer;

    static void solution() {
        while (true) {
            moved = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        search(i, j);
                    }
                }
            }
            if (!moved)
                break;
            answer += 1;
        }
        System.out.println(answer);
    }

    static void search(int x, int y) {
        // 상, 우, 하, 좌
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        Queue<Node> queue = new LinkedList<>();
        List<Node> union = new ArrayList<>();

        queue.add(new Node(x, y));
        union.add(new Node(x, y));
        visited[x][y] = true;

        int sum = arr[x][y];
        int count = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            x = now.x;
            y = now.y;

            // 현재 위치에서 4가지 방향을 확인하며 바로 옆에 있는 나라를 확인하여
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny])
                    continue;

                // 옆에 있는 나라와 인구 차이가 L명 이상, R명 이하라면 연합에 추가하기
                int gap = Math.abs(arr[x][y] - arr[nx][ny]);
                if (l <= gap && gap <= r) {
                    queue.add(new Node(nx, ny));
                    union.add(new Node(nx, ny));
                    visited[nx][ny] = true;

                    sum += arr[nx][ny];
                    count += 1;
                }
            }
        }

        if (union.size() > 1) {
            System.out.println(sum + " ," + count);
            moved = true;
            // 연합 국가끼리 인구를 분배
            int population = sum / count;
            for (Node node : union) {
                arr[node.x][node.y] = population;
            }
        }
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        solution();
    }
}
