package com.codingtest.exam.thisiscodingtest.ch15;

import java.util.Scanner;

public class Q27 {
    static int n;
    static int x;
    static int[] arr;

    // x보다 크거나 같은 첫 번째 위치(이상) 반환 
    static int lowerBound(int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (x > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    // x보다 큰 첫 번째 위치(초과) 반환 
    static int uppderBound(int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (x >= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    static int solution() {
        int start = 0;
        int end = n - 1;

        int left = lowerBound(start, end);
        int right = uppderBound(start, end);

        System.out.println(right);
        System.out.println(left);

        return right - left;
    }

    public static void main(String[] args) {
        /*
 7 2
 1 1 2 2 2 2 3
         */
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 값이 [x, x] 범위에 있는 데이터의 개수 계산
        int cnt = solution();
        // 값이 x인 원소가 존재하지 않는 경우 -1을 출력
        if (cnt > 0) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
        sc.close();
    }
}
