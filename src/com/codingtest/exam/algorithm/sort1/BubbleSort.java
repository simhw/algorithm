package com.codingtest.exam.algorithm.sort1;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
     static public void bubbleSort(ArrayList<Integer> dataList) {
//        for (int i = dataList.size() - 1; i > 0; i--) {
//            for (int j = 0; j < i; j++){
//                if (dataList.get(j) > dataList.get(j + 1)) {
//                    Collections.swap(dataList, j, j + 1);
//                }
//            }
//        }

        for (int i = 0; i < dataList.size() - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < dataList.size() - 1 - i; j++) {
                if (dataList.get(j) > dataList.get(j + 1)) {
                    Collections.swap(dataList, j, j + 1);
                    swap = true;
                }
            }
            if (swap == false) {
                break;
            }
        }
    }
    public static void main(String[] args) {

         ArrayList<Integer> dataList = new ArrayList<Integer>();
         for (int i = 0; i < 10; i++) {
             dataList.add((int)(Math.random() * 100));
         }
         System.out.print(dataList);
         System.out.println();
         bubbleSort(dataList);
         System.out.print(dataList);
    }
}
