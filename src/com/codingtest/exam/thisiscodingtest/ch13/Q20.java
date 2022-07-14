package com.codingtest.exam.thisiscodingtest.ch13;

import java.util.Scanner;

// 감시 피하기
public class Q20 {
    static int n;
    static int[][] board;
    static int[][] temp;
    static boolean answer;

    static void solution() {
        temp = new int[n][n];
        // 빈 공간에 장애물 3개를 설치하는 모든 경우
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
                    temp[i][j] = board[i][j];
                }
            }
            // 장애물 설치 이후, 한 명이라도 학생이 감지되는지 검사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 모든 선생님의 위치를 하나씩 확인
                    if (temp[i][j] == 2) {
                        if (!search(i, j)) {
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
                if (board[i][j] == 0) {
                    board[i][j] = 3;
                    combination(k + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    // 상, 하, 좌, 우 방향으로 감시를 진행
    static boolean search(int x, int y) {
        int nx = 0;
        int ny = 0;
        for (int i = 0; i < 4; i++) {
            // 위쪽 방향으로 감시
            if (i == 0) {
                nx = x + (-1);
                while (nx >= 0) {
                    // 학생이 있는 경우
                    if (temp[nx][y] == 1) {
                        return false;
                    }
                    // 장애물이 있는 경우
                    if (temp[nx][y] == 3) {
                        break;
                    }
                    nx -= 1;
                }
            }
            // 아래쪽 방향으로 감시
            if (i == 1) {
                nx = x + 1;
                while (nx < n) {
                    // 학생이 있는 경우
                    if (temp[nx][y] == 1) {
                        return false;
                    }
                    // 장애물이 있는 경우
                    if (temp[nx][y] == 3) {
                        break;
                    }
                    nx += 1;
                }
            }
            // 왼쪽 방향으로 감시
            if (i == 2) {
                ny = y + (-1);
                while (ny >= 0) {
                    // 학생이 있는 경우
                    if (temp[x][ny] == 1) {
                        return false;
                    }
                    // 장애물이 있는 경우
                    if (temp[x][ny] == 3) {
                        break;
                    }
                    ny -= 1;
                }
            }
            // 오른쪽 방향으로 감시
            if (i == 3) {
                ny = y + 1;
                while (ny < n) {
                    // 학생이 있는 경우
                    if (temp[x][ny] == 1) {
                        return false;
                    }
                    // 장애물이 있는 경우
                    if (temp[x][ny] == 3) {
                        break;
                    }
                    ny += 1;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String str = sc.next();
                if (str.equals("S")) {
                    board[i][j] = 1;
                } else if (str.equals("T")) {
                    board[i][j] = 2;
                }
            }
        }
        solution();
    }
}
