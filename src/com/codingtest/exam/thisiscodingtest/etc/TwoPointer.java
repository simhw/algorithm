package com.codingtest.exam.thisiscodingtest.etc;

import java.util.*;

// 투 포인터 
public class TwoPointer {
    // 특정한 합을 가지는 부분 연속 수열 찾기
    static void solution1(int[] arr, int n, int m) {
        int result = 0;
        int sum = 0;
        int end = 0;

        // start를 차례대로 증가시키며 반복
        for (int start = 0; start < n; start++) {
            // end를 가능한 만큼 이동시키기
            while (sum < m && end < n) {
                sum += arr[end];
                end += 1;
            }
            // 부분합이 m일 때 카운트 증가
            if (sum == m) {
                result += 1;
            }
            sum -= arr[start];
        }
        System.out.println(result);
    }

    // 정렬되어 있는 두 리스트의 합집합
    static void solution2(int[] a, int[] b, int n, int m) {
        // 리스트 a와 b의 모든 원소를 담을 수 있는 크기의 결과 리스트 초기화
        int[] arr = new int[n + m];
        int k = 0;

        for (int i = 0, j = 0; i < n || j < m; k++) {
            // 리스트 b의 모든 원소가 처리되었거나, 리스트 b의 원소가 더 작을 때
            if (j >= m || (i < n && a[i] <= b[j])) {
                arr[k] = a[i];
                i += 1;
            }
            // 리스트 a의 모든 원소가 처리되었거나, 리스트 a의 원소가 더 작을 때
            else {
                arr[k] = b[j];
                j += 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // 구간 합 계산
    static void solution3(int[] arr, int n, int left, int right) {
        // 접두사 합 배열 계산
        List<Integer> prefix = new ArrayList<>();
        prefix.add(0);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            prefix.add(sum);
        }
        // 구간 합 계산
        // P[R] - P[L - 1]
        System.out.println(prefix.get(right) - prefix.get(left - 1));
    }

    public static void main(String[] args) {
        solution1(new int[] { 1, 2, 3, 2, 5 }, 5, 5);

        int a[] = { 1, 3, 5 };
        int b[] = { 2, 4, 6, 8 };
        solution2(a, b, a.length, b.length);

        solution3(new int[] { 10, 20, 30, 40, 50 }, 5, 3, 4);
    }
}
