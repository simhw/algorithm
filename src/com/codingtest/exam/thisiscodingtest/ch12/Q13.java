package com.codingtest.exam.thisiscodingtest.ch12;

import java.util.*;

// 치킨 배달
// 삼성전자 SW 역량테스트

public class Q13 {
    static int N, M;
    static List<List<Integer>> houses;
    static List<List<Integer>> chickens;

    static List<Integer> cases  = new ArrayList<>();

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int a = sc.nextInt();
                // 0: 빈칸, 1: 집, 2: 치킨집
                if (a == 1) {
                    houses.add(new ArrayList<>(Arrays.asList(i, j)));
                } else if (a == 2) {
                    chickens.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
    }

    static void solution() {
        int answer = 0;
        // 모든 치킨집 중에서 M 개의 치킨집을 뽑는 조합 계산
        combination(chickens.size(), 0, new int[M]);
        // 치킨 거리의 합의 최소를 찾아 출력
        answer = Collections.min(cases);
        System.out.println(answer);
    }


    // 치킨 거리의 합을 계산하는 함수
    static int getDistance (int[] selected) {
        int sum = 0;
        // 모든 집에 대하여
        for (List<Integer> house : houses) {
            int distance = Integer.MAX_VALUE;
            int a = house.get(0);
            int b = house.get(1);

            // 가장 가까운 치킨 집 찾기
            for (int index : selected) {
                List<Integer> chicken = chickens.get(index);
                int x = chicken.get(0);
                int y = chicken.get(1);

                // 유클리디안 거리
                distance = Math.min(distance, Math.abs(a - x) + Math.abs(b - y));
            }
            // 가장 가까운 치킨집까지의 거리를 더하기
            sum += distance;
        }
        return sum;
    }
    static void combination(int n, int k, int[] selected) {
        if (k == M) {
            // 치킨 거리 계산
            cases.add(getDistance(selected));
        } else {
            int start = k == 0 ? 0 : selected[k - 1] + 1;
            for (int i = start; i < n; i++) {
                selected[k] = i;
                combination(n, k + 1, selected);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
/*
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
 */
        input();
        solution();
    }
}
