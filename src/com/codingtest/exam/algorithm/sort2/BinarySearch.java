package com.codingtest.exam.algorithm.sort2;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public static boolean binarySearch(ArrayList<Integer> dataList, Integer findItem) {
        Integer midIdx = dataList.size() / 2;
        Integer mid = dataList.get(midIdx);

        if (dataList.size() < 1) {
            return false;
        }
        // CASE 1
        if (mid == findItem) return true;
            // CASE 2
        else if (mid > findItem) {
            return binarySearch(new ArrayList<>(dataList.subList(0, midIdx)), findItem);
        }
        // CASE 3
        else {
            return binarySearch(new ArrayList<>(dataList.subList(midIdx, dataList.size())), findItem);
        }
    }
    public static void main(String[] args) {
        // 단, 배열이 졍렬된 상태에서만 사용가능하다.
        ArrayList<Integer> dataList = new ArrayList<>(Arrays.asList(3, 6, 8, 15, 24, 28, 32, 37, 42, 46, 49, 50, 67, 999));
        boolean find = binarySearch(dataList, 8);
        System.out.println("findItem: " + find);
    }
}
