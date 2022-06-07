package com.codingtest.exam.thisiscodingtest.ch07;

// 순차 탐색

public class Ex01 {
    static int sequential(int n, int target, int[] array) {
        // 각 원소를 하나씩 확인하며
        for (int i = 0; i < n; i++) {
            if (array[i] == target) {
                System.out.println(array[i]);
                return i + 1;   // 현재의 위치 반환
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = new int[]{2, 28, 34, 64, 56, 55, 20 ,60, 45, 11};
        sequential(array.length, 20, array);
    }
}
