package com.codingtest.exam.thisiscodingtest.ch03;

// 예제 3-1 거스름돈

// <문제>
// 손님에게 거슬러 줘야 할 돈이 N 원일 때 거슬러 줘야 할 동전의 최소 개수를 구하라.

// <해결>
// '가장 큰 화폐 단위부터' 돈을 거슬러 준다.
// 가지고 있는 동전 중에서 큰 단위가 항상 작은 단위의 배수이므로 작은 단위의 동전들을 종합해 다른 해가 나올 수 없기 때문이다.

import java.util.Scanner;

public class Ex01 {
    static int N;
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int answer = 0;
        int[] coins = {500, 100, 50, 10};

        for (int i = 0; i < coins.length; i++) {
            answer += N / coins[i];
            N %= coins[i];
        }

        System.out.println(answer);
        sc.close();
    }
    public static void main(String[] args) {
        solution();
    }
}
