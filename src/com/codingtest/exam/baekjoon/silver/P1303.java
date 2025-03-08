package com.codingtest.exam.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 전쟁 - 전투
 * https://www.acmicpc.net/problem/1303
 */
public class P1303 {
    static int n, m;
    static char[][] board;

    public static void solution() {
        int white = 0;
        int blue = 0;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    int count = search(visited, i, j);
                    int power = count * count;

                    if (board[i][j] == 'W') {
                        white += power;
                    }

                    if (board[i][j] == 'B') {
                        blue += power;
                    }
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    public static int search(boolean[][] visited, int x, int y) {
        int count = 1;

        // 상, 하, 좌, 우
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            if (visited[nx][ny] || board[nx][ny] != board[x][y]) {
                continue;
            }
            count += search(visited, nx, ny);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[j][i] = line.charAt(j);
            }
        }
        solution();
    }
}
