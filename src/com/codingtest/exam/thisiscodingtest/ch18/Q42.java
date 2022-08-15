package com.codingtest.exam.thisiscodingtest.ch18;

import java.util.*;

// 탑승구 
public class Q42 {
    static int g, p;
    static int[] plane;

    static void solution() {
        // 탑승구를 자기 자신으로 초기화
        int[] gate = new int[g + 1];
        for (int i = 0; i < g + 1; i++) {
            gate[i] = i;
        }

        int reuslt = 0;
        for (int i = 0; i < p; i++) {
            // 현재 비행기의 탑승구의 부모 확인
            int n = find(gate, plane[i]);
            // 부모가 0이라면 종료
            if (n == 0)
                break;
            // 그렇지 않다면 왼쪽에 있는 집합과 union 연산
            union(gate, n, n - 1);
            reuslt += 1;
            System.out.println("i:" + i + " " + Arrays.toString(gate));
        }
        System.out.println(reuslt);
    }

    static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        g = sc.nextInt();
        p = sc.nextInt();

        plane = new int[p];
        for (int i = 0; i < p; i++) {
            plane[i] = sc.nextInt();
        }
        solution();
        sc.close();
    }
}
