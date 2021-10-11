package com.codingtest.exam.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

// 삽입 정렬 (Insertion Sort)
// 1. 삽입 정렬은 두 번째 인덱스부터 시작
// 2. 해당 인덱스(key 값) 앞에 있는 데이터(B)부터 비교해서 key 값이 더 작으면, B값을 뒤 인덱스로 복사
// 3. 이를 key 값이 더 큰 데이터를 만날때까지 반복, 그리고 큰 데이터를 만난 위치 바로 뒤에 key 값을 이동
public class InsertionSort {
    public static void insertionSort(ArrayList<Integer> dataList) {
        for (int i = 0; i < dataList.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (dataList.get(j - 1) > dataList.get(j)) {
                    Collections.swap(dataList, j - 1, j);
                }
                else break;
                // 완전 정렬이 되어 있는 상태라면 최선은 O(n)
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            dataList.add((int)(Math.random() * 100));
        }
        System.out.println(dataList);
        insertionSort(dataList);
        System.out.println(dataList);
    }
}
