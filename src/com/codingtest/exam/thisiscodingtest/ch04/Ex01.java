package com.codingtest.exam.thisiscodingtest.ch04;

// 예제 4-1 상하좌우

import java.util.Scanner;

public class Ex01 {
    static int N;
    static String direction;

    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        direction = sc.nextLine();
        sc.close();
    }

    public static void solution() {

        int x = 1, y = 1;

        // 좌, 우, 상, 하에 따른 이동 방향
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        char[] moves = new char[]{'L', 'R', 'U', 'D'};

        for (int i = 0; i < direction.length(); i++) {
            char dir = direction.charAt(i);
            int nx = 0, ny = 0;
            for (int j = 0; j < moves.length; j++) {
                if (dir == moves[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            // 공간을 벗어나는 경우 무시
            if (nx < 1 || nx > N || ny < 1 || ny > N) {
                continue;
            }
            x = nx;
            y = ny;
        }
        System.out.println(x + " " + y);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
