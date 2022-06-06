package com.codingtest.exam.thisiscodingtest.ch06;

// 예제 6-10 위에서 아래로

// <문제>
// 수열을 내림차순으로 정렬하는 프로그램 작성하라.

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex05 {
    static int N;
    static Integer array[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        // 기본 정렬 라이브러리 이용
        Arrays.sort(array, Collections.reverseOrder());

        System.out.println(Arrays.toString(array));
    }
}
