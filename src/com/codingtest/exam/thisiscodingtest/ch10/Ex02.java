package com.codingtest.exam.thisiscodingtest.ch10;

// 서로소 집합을 활용한 사이클 판별

// 1. 각 간선을 확인하며 두 노드의 루트 노드를 확인한다.
// 1-1. 루트 노드가 다르다면 두 노드에 대하여 union 연산을 수행한다.
// 1-2. 루트 노드가 서로 같다면 사이클이 발생한 것이다.
// 2. 그래프에 포함되어 있는 모든 간선에 대하여 1 번 과정을 반복한다.

import java.util.Scanner;

public class Ex02 {
    static int V, E;
    static int[] parent;

    static void solution() {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        parent = new int[V + 1];
        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }

        boolean cycle = false;
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 사이클이 발생한 경우 종료
            if (findParent(a) == findParent(b)) {
                cycle = true;
                break;
            }
            // 사이클이 발생하지 않았다면 합집합 수행
            unionParent(a, b);

            if (cycle) {
                System.out.println("cycle");
            } else {
                System.out.println("cycle x");
            }
        }
    }

    static int findParent(int x) {
        if (x != parent[x]) {
            // 함수를 재귀적으로 호출한 뒤 부모 테이블 값을 갱신
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        solution();
    }
}