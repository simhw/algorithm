package com.codingtest.exam.thisiscodingtest.ch06;

// 삽입 정렬

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        for (int i = 1; i < array.length; i++) {
            // 인덱스 i 부터 1 까지 감소하며 반복
            for (int j = i; j > 0; j--) {
                // 한 칸씩 왼쪽으로 이동
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    // 자신보다 작은 데이터를 만나면 그 위치에서 멈춤
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
