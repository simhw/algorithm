package com.codingtest.exam.thisiscodingtest.ch06;

import java.util.Arrays;

// 선택 정렬

public class Ex01 {
    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 0; i < array.length; i++) {
            // 가장 작은 원소의 위치
            int min = i;
            // 가장 작은 원소를 찾기 위한 비교 연산
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            // swap
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
