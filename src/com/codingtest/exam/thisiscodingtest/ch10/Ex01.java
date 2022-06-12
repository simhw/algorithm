package com.codingtest.exam.thisiscodingtest.ch10;

// 서로소 집합
// 공통 원소가 없는 두 집합
// 각 집합이 어떤 원소를 공통으로 가지고 있는지 확인

import java.util.Scanner;

public class Ex01 {
    static int V, E;
    static int[] parent;

    static void solution() {
        // 1. 합집합 연산을 확인하여, 서로 연결된 두 노드 A, B 확인
        // 1-1. A 와 B 의 루트 노드를 각각 찾기
        // 1-2. A 를 B 의 부모 노드로 설정
        // 2. 모든 합집합 연산을 처리할 때까지 1 번 과정 반복

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }

    }
    static void find() {

    }
    static void union() {

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        parent = new int[V + 1];

    }
}
