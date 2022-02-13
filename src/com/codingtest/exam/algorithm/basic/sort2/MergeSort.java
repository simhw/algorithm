package com.codingtest.exam.algorithm.basic.sort2;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void splitFunc(ArrayList<Integer> dataList) {

        if (dataList.size() <= 1){
            return;
        }
        int medium = dataList.size() / 2;
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        leftArr = new ArrayList<> (dataList.subList(0, medium));    // 0 부터 medium - 1 까지
        rightArr = new ArrayList<> (dataList.subList(medium, dataList.size())); // 0 medium 부터 size - 1 까지

        System.out.println(leftArr);
        System.out.println(rightArr);
    }
    // 1. 정렬되지 않은 배열을 끝까지 분리한다.
    public static ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1){
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        leftArr = mergeSplitFunc(new ArrayList<> (dataList.subList(0, medium)));    // 0 부터 medium - 1 까지
        rightArr = mergeSplitFunc(new ArrayList<> (dataList.subList(medium, dataList.size()))); // 0 medium 부터 size - 1 까지

        return mergeFunc(leftArr, rightArr);
    }

    // 2. 분리한 데이터를 단계별로 합친다.
    public static ArrayList<Integer> mergeFunc(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
        System.out.println(leftArr);
        System.out.println(rightArr);

        ArrayList<Integer> mergedList = new ArrayList<>();
        int lIdx = 0;
        int rIdx = 0;

        // CASE 1
        // left, right 모두 남아있는 경우
        while (lIdx < leftArr.size() && rIdx < leftArr.size()) {
            if (leftArr.get(lIdx) < rightArr.get(rIdx)) {
                mergedList.add(leftArr.get(lIdx));
                lIdx++;
            }
            else{
                mergedList.add(rightArr.get(rIdx));
                rIdx++;
            }
        }
        // CASE 2
        // left 데이터가 남아있는 경우
        if (lIdx < leftArr.size()) {
            while (lIdx < leftArr.size()) {
                mergedList.add(leftArr.get(lIdx));
                lIdx++;
            }
        }
        // CASE 3
        // right 데이터가 남아있는 경우
        else if (rIdx < rightArr.size()) {
            while (rIdx < rightArr.size()) {
                mergedList.add(rightArr.get(rIdx));
                rIdx++;
            }
        }

        System.out.println(mergedList);
        return mergedList;
    }
    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>(Arrays.asList(4, 1, 2, 6, 5, 7, 5, 8));
        System.out.println(mergeSplitFunc(dataList));
    }
}
