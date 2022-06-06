package com.codingtest.exam.thisiscodingtest.ch06;

// 퀵 정렬

import java.util.Arrays;

public class Ex03 {
    static void quick(int[] array, int start, int end) {
        // 원소가 1 개인 경우 종료
        if (start >= end) {
            return;
        }

        // 피벗은 첫 번째 원소
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            // 피벗보다 큰 데이터를 찾을 때까지 반복
            while (left <= end && array[left] <= array[pivot]) {
                left += 1;
            }
            // 피벗보다 작은 데이터를 찾을 때까지 반복
            while (right > start && array[right] >= array[pivot]) {
                right -= 1;
            }
            // 엇갈렸다면 작은 데이터와 피벗을 교체
            if (left > right) {
                int temp = array[pivot];
                array[pivot] = array[right];
                array[right] = temp;

            }
            // 엇갈리지 않았다면 작은 데이터와 큰 데이터 교체
            else {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
            // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
            quick(array, start, right - 1);
            quick(array, right + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        quick(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
