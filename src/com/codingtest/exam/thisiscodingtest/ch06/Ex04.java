package com.codingtest.exam.thisiscodingtest.ch06;

// 계수 정렬

import java.util.Arrays;

public class Ex04 {
    public static void main(String[] args) {
        // 모든 원소의 값이 0 보다 크거나 같다고 가정
        int[] array = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        // 모든 범위를 포함하는 리스트 선언 (모든 값은 0 으로 초기화)
        int[] count = new int[10];

        for (int i = 0; i < array.length; i++) {
            count[array[i]] += 1;   // 각 데이터에 해당하는 인덱스의 값 증가
        }
        System.out.println(Arrays.toString(count));

        for (int i = 0; i < count.length; i++) {    // 리스트에 기록된 정렬 정보 확인
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " "); // 등장한 횟수만큼 인덱스 출력
            }
        }
    }
}
