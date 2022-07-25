package com.codingtest.exam.thisiscodingtest.ch10;

import java.util.Arrays;
import java.util.Scanner;

// 서로소 집합
// 공통 원소가 없는 두 집합

// 1. 합집합 연산을 확인하여, 서로 연결된 두 노드 A, B 확인
// 1-1. A 와 B 의 루트 노드를 각각 찾기
// 1-2. A 를 B 의 부모 노드로 설정
// 2. 모든 합집합 연산을 처리할 때까지 1 번 과정 반복
public class Ex01 {
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

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }
        sc.close();

        System.out.println(Arrays.toString(parent));
    }

    // 두 원소가 속한 집합 찾기
    static int findParent1(int x) {
        // 루트 노드가 아니라면 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x != parent[x]) {
            return findParent1(parent[x]);
        }
        return x;
    }

    // 경로 압축 기법
    static int findParent2(int x) {
        if (x != parent[x]) {
            // 함수를 재귀적으로 호출한 뒤 부모 테이블 값을 갱신
            parent[x] = findParent2(parent[x]);
        }
        return parent[x];
    }

    // 두 원소가 속한 집합 합치기
    static void unionParent(int a, int b) {
        a = findParent2(a);
        b = findParent2(b);
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
