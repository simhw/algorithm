package com.codingtest.exam.thisiscodingtest.ch06;

import java.util.*;
import java.util.Map.Entry;

public class Re06 {
    // 선택 정렬
    static void ex01(int[] arr) {

    }

    // 삽입 정렬
    static void ex02(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 인덱스 i 부터 1 까지 감소하며 반복
            for (int j = i; j > 0; j--) {
                // 자신보다 작은 데이터를 만나면 그 위치에서 멈춤
                if (arr[j] > arr[j - 1]) {
                    break;
                } else {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // 퀵 정렬
    static void ex03(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            // 왼쪽에서부터 피벗보다 큰 데이터 선택
            while (left <= end && arr[pivot] >= arr[left]) {
                left += 1;
            }
            // 오른쪽에서부터 피벗보다 작은 데이터 선택
            while (right > start && arr[pivot] <= arr[right]) {
                right -= 1;
            }
            if (left <= right) {
                System.out.println(arr[left] + ", " + arr[right] + " swap");
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            } else {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }
        }
        ex03(arr, 0, right - 1);
        ex03(arr, right + 1, end);
    }

    // 계수 정렬
    static void ex04(int[] arr) {
        // 모든 범위를 포함하는 리스트 선언
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            count[num] += 1;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }

    // 위에서 아래로
    static void ex05(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }

    static void ex06() {
        HashMap<String, Integer> students = new HashMap<>();
        students.put("홍길동", 95);
        students.put("이순신", 77);
        students.put("장보고", 83);

        List<Map.Entry<String, Integer>> entries = new LinkedList<>(students.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
    }

    // 두 배열의 원소 교체
    static void ex07() {
        int n = 5;
        int k = 3;
        int[] a = new int[] { 1, 2, 3, 4, 5 };
        int[] b = new int[] { 5, 5, 6, 6, 5 };

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < k; i++) {
            if (a[i] < b[(n - i) - 1]) {
                a[i] = b[(n - i) - 1];
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += a[i];
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        // ex03(new int[]{ 5, 7, 9, 0, 3, 1, 6, 2, 4, 8 } , 0, arr.length - 1);
        // ex04(new int[] { 7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2 });

        // ex05(new Integer[] { 3, 15, 27, 12 });
        // ex06();
        // ex07();
    }
}
