package com.codingtest.exam.thisiscodingtest.ch15;

import java.util.Scanner;

// 고정점 찾기 
public class Q28 {
    static int n;
    static int[] arr;

    static void mysolution() {
        int start = 0;
        int end = n - 1;
        while (start < end) {
            // '찾고자 하는 값'이 '중간점'과 동일하다고 가정
            int mid = (start + end) / 2;
            if (arr[mid] < mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (arr[end] == end) {
            System.out.println(end);
        } else {
            System.out.println(-1);
        }
    }

    static int solution(int start, int end) {
        if (start > end) {
            return -1;
        } else {
            int mid = (start + end) / 2;
            // 고정점을 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == mid) {
                return mid;
            }
            // 중간점의 값보다 중간점이 작은 경우 왼쪽 확인
            else if (arr[mid] > mid) {
                return solution(start, mid - 1);
            }
            // 중간점의 값보다 중간점이 큰 경우 오른쪽 확인
            else {
                return solution(mid + 1, end);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int answer = solution(0, n - 1);
        System.out.println(answer);
    }
}
