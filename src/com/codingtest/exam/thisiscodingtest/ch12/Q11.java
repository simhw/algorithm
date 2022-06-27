package com.codingtest.exam.thisiscodingtest.ch12;

// 뱀 (삼성전자 sw 역량 테스트)

import java.util.*;

class Node {
    int time;
    char direction;

    Node(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }
}

class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + "x=" + x + ", y=" + y + '}';
    }
}

public class Q11 {
    static Scanner sc = new Scanner(System.in);
    static int N, K, L;
    static int[][] graph;
    static List<Node> info;

    public static void input() {
        N = sc.nextInt();
        K = sc.nextInt();
        graph = new int[N + 1][N + 1];
        // 사과가 있는 곳은 1 로 표시
        for (int i = 0; i < K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        // 방향 회전 정보 입력
        L = sc.nextInt();
        info = new ArrayList<>(L);
        for (int i = 0; i < L; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            info.add(new Node(x, c));
        }
    }

    public static int turn(int direction, char c) {
        if (c == 'L') {
            direction = (direction == 0) ? 3 : direction - 1;
        } else {
            direction = (direction + 1) % 4;
        }
        return direction;
    }

    public static void solution() {
        // 처음에는 오른쪽을 보고 있으므로 (동, 남, 서, 북)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        // 뱀의 머리 위치
        int x = 1, y = 1;
        // 뱀이 존재하는 위치는 2 로 입력
        graph[x][y] = 2;
        // 처음에는 동쪽을 향하고 있음
        int direction = 0;
        // 시작한 뒤에 지난 시간(초)
        int time = 0;
        // 다음에 회전할 정보
        int index = 0;
        // 뱀이 차지하고 있는 위치 정보
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 그래프 범위 안에 있고, 뱀의 몸통이 없는 위치인 경우
            if (1 <= nx && nx < N + 1 && 1 <= ny && ny < N + 1 && graph[nx][ny] != 2) {
                // 사과가 없다면 이동 후에 꼬리 제거
                if (graph[nx][ny] != 1) {
                    Position prev = queue.poll();
                    graph[prev.x][prev.y] = 0;
                }
                // 뱀의 몸길이를 늘려 머리를 다음 칸에 위치
                graph[nx][ny] = 2;
                queue.add(new Position(nx, ny));
            }
            // 벽이나 뱀의 몸퉁에 부딪힌 경우
            else {
                time += 1;
                break;
            }
            x = nx;
            y = ny;
            time += 1;
            // 회전할 시간인 경우 회전
            if (index < L && time == info.get(index).time) {
                direction = turn(direction, info.get(index).direction);
                index += 1;
            }
        }
        System.out.println(time);
    }

    public static void main(String[] args) {
/*
10
5
1 5
1 3
1 2
1 6
1 7
4
8 D
10 D
11 D
13 L
 */
        input();
        solution();
    }
}
