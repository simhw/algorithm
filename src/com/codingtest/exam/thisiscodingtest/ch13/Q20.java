package com.codingtest.exam.thisiscodingtest.ch13;

import java.util.Scanner;

//
public class Q20 {

    static int n;
    static int[][] arr;
    static int[][] temp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean answer;

    static void solution() {
        temp = new int[n][n];
        combination(0);

        if (answer) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void combination(int k) {
        if (k == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (temp[i][j] == 2) {
                        if (!dfs(i, j)) {
                            return;
                        }
                    }
                }
            }
            answer = true;
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 3;
                    combination(k + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    static boolean dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            // student: 1, teacher: 2, obstacle: 3
            if (temp[nx][ny] == 0) {
                temp[nx][ny] = 2;
                dfs(nx, ny);
            } else if (temp[nx][ny] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String str = sc.next();
                if (str.equals("S")) {
                    arr[i][j] = 1;
                } else if (str.equals("T")) {
                    arr[i][j] = 2;
                }
            }
        }
        solution();
    }
}
