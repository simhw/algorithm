package com.codingtest.exam.thisiscodingtest.ch11;

// 만들 수 없는 금액
// <해결>
// 화폐 단위가 작은 순서대로 동전을 확인하며, 현재 확인하는 동전을 이용해 target 금액 또한 만들 수 있는지 확인

import java.util.*;

public class Q04 {
    static int N;
    static int[] current;
    static Set<Integer> set = new HashSet<>();

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        current = new int[N];
        for (int i = 0; i < N; i++) {
            current[i] = sc.nextInt();
        }
    }

    static void solution() {
        Arrays.sort(current);

        int target = 1;
        for (int i = 0; i < N; i++) {
            if (target < current[i]) {
                break;
            }
            target += current[i];
            // target - 1 까지 모든 금액을 만들 수 있다는 말
        }
    }

    static void mysolution() {
        // 더해서 나올 수 있는 모든 경우 확인
        for (int r = 1; r <= N; r++) {
            combination(r, 0, 0, 0);
        }
        int max = Collections.max(set);
        int result = max;
        for (int i = 1; i <= max; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (result > i) {
                result = i;
            }
        }
        System.out.println(result);
    }


    static void combination(int r, int k, int start, int total) {
        if (k == r) {
            set.add(total);
        } else {
            for (int i = start; i < N; i++) {
                total += current[i];
                combination(r, k + 1, i + 1, total);
                total -= current[i];
            }
        }
    }

    public static void main(String[] args) {
        /*
5
3 2 1 1 9
         */
        input();
        solution();
    }
}
