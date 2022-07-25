package com.codingtest.exam.thisiscodingtest.ch04;

// 예제 4-4 게임 개발

import java.util.Scanner;

public class Ex04 {

    static int N, M;
    static int x, y, d;
    static int[][] array;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        d = sc.nextInt();

        // 전체 맵 정보 입력
        array = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    // 반시계 방향으로 90 도 회전
    static int turnLeft() {
        d -= 1;
        if (d == -1) {
            d = 3;
        }
        return d;
    }

    static void solution() {
        int[][] visited = new int[N][M];
        // 현재 좌표 방문 처리
        visited[x][y] = 1;

        // 북, 동, 남, 서 방향 정의
        int[] dx = new int[] { -1, 0, 1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };

        int count = 1;
        int turn = 0;

        int nx = 0, ny = 0;
        while (true) {
            turnLeft();
            nx = x + dx[d];
            ny = y + dy[d];

            // 회전한 이후 정면에 방문하지 않은 육지가 있는 경우 이동
            if (visited[ny][ny] == 0 && array[nx][ny] == 0) {
                visited[nx][ny] = 1;
                x = nx;
                y = ny;
                count += 1;
                turn = 0;
                continue;
            } else {
                turn += 1;
            }
            if (turn > 3) {
                nx = x - dx[d];
                ny = y - dy[d];

                // 뒤로 갈 수 있는 경우
                if (array[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        input();
        // 4 4
        // 1 1 0
        // 1 1 1 1
        // 1 0 0 1
        // 1 1 0 1
        // 1 1 1 1
        solution();
    }

}
