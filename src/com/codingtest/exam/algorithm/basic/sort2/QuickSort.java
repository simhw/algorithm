package com.codingtest.exam.algorithm.basic.sort2;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    public static ArrayList<Integer> quickSort(ArrayList<Integer> dataList) {
        // 데이터 수가 1개 가 될 때까지 함수를 호출한다.
        if (dataList.size() <= 1) {
            return dataList;
        }

        int pivot = dataList.get(0);
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        int idx = 1;
        while (dataList.size() > idx) {
            if (pivot < dataList.get(idx)) {
                rightArr.add(dataList.get(idx));
            } else {
                leftArr.add(dataList.get(idx));
            }
            idx++;
        }
        System.out.print(leftArr);
        System.out.print(pivot);
        System.out.println(rightArr);

        ArrayList<Integer> mergedArr = new ArrayList<>();
        mergedArr.addAll(quickSort(leftArr));
        mergedArr.add(pivot);
        mergedArr.addAll(quickSort(rightArr));

        return mergedArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>(Arrays.asList(4, 3, 1, 7, 5, 6, 9, 2));
        System.out.println(quickSort(dataList));
    }

}
