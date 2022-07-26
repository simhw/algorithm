package com.codingtest.exam.thisiscodingtest.ch15;

import java.util.Arrays;
import java.util.Scanner;

// 공유기 설치 
// c보다 많은 개수로 공유기를 설치할 수 있다면 '가장 인접한 두 공유기 사이의 거리의 최댓값' 탐색  
public class Q29 {
    static int n, c;
    static int[] arr;

    static void solution() {
        Arrays.sort(arr);
        // 가능한 최소 거리 (min gap)
        int min = 1;
        // 가능한 최대 거리 (max gap)
        int max = arr[n - 1] - arr[0];
        int result = 0;

        while (min <= max) {
            // 가장 인접한 두 공유기 사이의 거리
            int gap = (min + max) / 2;
            int cnt = 1;
            // 첫째 집에는 무조건 공유기를 설치한다고 가정
            int temp = arr[0];

            // 앞에서부터 공유기 설치
            for (int i = 1; i < n; i++) {
                if (arr[i] - temp >= gap) {
                    temp = arr[i];
                    cnt += 1;
                }
            }
            // c개 이상의 공유기를 설치할 수 있는 경우, 거리를 증가시키기
            if (cnt >= c) {
                min = gap + 1;
                result = gap;
            }
            // c개 이상의 공유기를 설치할 수 없는 경우, 거리를 감소시키기
            else {
                max = gap - 1;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        solution();
    }
}
