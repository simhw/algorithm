package com.codingtest.exam.thisiscodingtest.ch18;

import java.util.*;

// 여행 계획 
public class Q41 {
    static int n, m;
    static int[][] arr;
    static int[] plan;

    // '여행 계획'에 해당하는 모든 노드가 집합에 속하기만 하면 가능한 여행 경로
    static void solution() {
        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        int[] parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                // 연결된 경우 union 연산 수행
                if (arr[i][j] > 0) {
                    union(parent, i + 1, j + 1);
                    System.out.println("i:" + i + " " + Arrays.toString(parent));
                }
            }
        }

        // 여행 계획에 속하는 모든 노드의 루트가 동일한지 확인
        boolean check = true;
        for (int i = 0; i < m - 1; i++) {
            if (parent[plan[i]] != parent[plan[i + 1]])
                check = false;
        }
        if (check) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    // 두 원소(a, b)가 속한 집합을 합치기
    static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    // 특정 원소(x)가 속한 집합을 찾기
    static int find(int[] parent, int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][n];
        plan = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            plan[i] = sc.nextInt();
        }
        solution();
        sc.close();
    }
}