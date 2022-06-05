package com.codingtest.exam.thisiscodingtest.ch04;

// 예제 4-3 왕실의 나이트

import java.util.Scanner;

public class Ex03 {
    static String knight;

    static void input() {
        Scanner sc = new Scanner(System.in);
        knight = sc.nextLine();
    }

    static void solution() {

        int row = knight.charAt(1) - 48;
        int col = knight.charAt(0) - 'a' + 1;

        int count = 0;

        // 1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
        // 2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기

        // 나이트가 이동할 수 있는 경우의 수는 총 8가지
        int[] dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};

        for (int i = 0; i < 8; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            // 해당 위치로 이동 가능하면 카운트 증가
            if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) {
                count += 1;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        input();
        solution();
    }
}
