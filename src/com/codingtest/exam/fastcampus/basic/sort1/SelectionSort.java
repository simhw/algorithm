package com.codingtest.exam.fastcampus.basic.sort1;

import java.util.ArrayList;
import java.util.Collections;
// 선택 정렬(Selection Sort)
// 1. 주어진 데이터 중, 최소값을 찾음
// 2. 해당 최소값을 데이터 맨 앞에 위치한 값과 교체함
// 3. 맨 앞의 위치를 뺀 나머지 데이터를 동일한 방법으로 반복함

public class SelectionSort {
    public static void selectionSort(ArrayList<Integer> dataList) {
        int lowest;
        for (int i = 0; i < dataList.size(); i++) {
            lowest = i;
            for (int j = i + 1; j < dataList.size(); j++) {
                if (dataList.get(lowest) > dataList.get(j)) {
                    lowest = j;
                }
            }
            Collections.swap(dataList, i, lowest);
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            dataList.add((int)(Math.random() * 100));
        }
        System.out.println(dataList);
        selectionSort(dataList);
        System.out.println(dataList);
    }
}
