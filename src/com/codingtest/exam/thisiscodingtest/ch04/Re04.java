package com.codingtest.exam.thisiscodingtest.ch04;

public class Re04 {

    // 상하좌우
    static void ex01() {
        int n = 5;
        char[] a = { 'R', 'R', 'R', 'U', 'D', 'D' };

        // L, R, U, D에 따른 이동 방향
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };
        char[] types = { 'L', 'R', 'U', 'D' };

        int x = 1, y = 1;

        for (int i = 0; i < a.length; i++) {
            int nx = x, ny = y;
            for (int j = 0; j < 4; j++) {
                if (a[i] == types[j]) {
                    nx += dx[j];
                    ny += dy[j];
                }
            }
            if (nx < 1 || nx > n || ny < 1 || ny > n) {
                continue;
            }
            x = nx;
            y = ny;
        }
        System.out.println(x + "  " + y);
    }

    // 시각
    static void ex02() {
        int n = 5;
        int answer = 0;

        // 86,400가지(24 * 60 * 60) 경우의 수 완전 탐색
        for (int time = 0; time < n + 1; time++) {
            for (int min = 0; min < 60; min++) {
                for (int sec = 0; sec < 60; sec++) {
                    String str = time + "" + min + "" + sec;
                    if (str.contains("3")) {
                        answer += 1;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    // 왕실의 나이트
    static void ex03() {
        // 현재 나이트의 위치
        char row = 1;
        int col = 'a';

        int x = row;
        int y = col - 'a' + 1;

        // 나이트가 이동할 수 있는 8가지 방향 정의
        int[] dx = { -2, -2, 2, 2, -1, -1, 1, 1 };
        int[] dy = { -1, 1, -1, 1, -2, 2, -2, 2 };

        int answer = 0;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 1 || nx > 8 || ny < 1 || ny > 8) {
                continue;
            }
            answer += 1;
        }
        System.out.println(answer);
    }

    // 게임 개발
    static void ex04() {
        int n = 4, m = 4;
        int x = 1, y = 1, d = 0;
        int[][] map = {
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 }
        };

        // 북, 동, 남, 서 방향 정의
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        int[][] visited = new int[n][m];
        visited[x][y] = 1;

        int answer = 1;
        int turn = 0;

        while (true) {
            // 왼쪽으로 회전
            d -= 1;
            if (d == -1)
                d = 3;

            int nx = x + dx[d];
            int ny = y + dy[d];

            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
            if (visited[nx][ny] == 0 && map[nx][ny] == 0) {
                x = nx;
                y = ny;
                visited[x][y] = 1;
                answer += 1;
                turn = 0;
                continue;
            }
            // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
            else {
                turn += 1;
            }
            // 네 뱡향 모두 갈 수 없는 경우
            if (turn == 4) {
                nx = x - dx[d];
                ny = y - dy[d];
                // 뒤가 바다가 아니라면 이동
                if (map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    turn = 0;
                } else {
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        ex04();
    }
}
