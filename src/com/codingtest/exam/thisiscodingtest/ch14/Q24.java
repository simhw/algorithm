package com.codingtest.exam.thisiscodingtest.ch14;

import java.util.*;

// 안테나
public class Q24 {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        // 중간값에 해당하는 위치의 집에 안테나를 설치했을 때,
        // 안테나로부터 모든 집까지의 거리의 총합이 최소가 된다.
        System.out.println(arr[(n - 1) / 2]);
    }
}
