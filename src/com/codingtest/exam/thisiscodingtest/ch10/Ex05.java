package com.codingtest.exam.thisiscodingtest.ch10;

// 예제 10-7 팀 결성

import java.util.Scanner;

public class Ex05 {
    static int N, M;
    static int[] team;

    static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        team = new int[N];

        for (int i = 0; i < M; i++) {
            int operation = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            // union
            if (operation == 0) {
                unionParent(a, b);
            }
            // find
            if (operation == 1) {
                if (findParent(a) == findParent(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }

    static int findParent(int x) {
        if (x != team[x]) {
            team[x] = findParent(team[x]);
        }
        return team[x];
    }

    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            team[b] = a;
        } else {
            team[a] = b;
        }
    }

    public static void main(String[] args) {
        solution();
    }
}