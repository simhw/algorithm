package com.codingtest.exam.algorithm.basic;

import java.util.ArrayList;

public class Factorial {
    public static int factFucn1(ArrayList<Integer> dataList) {
        if (dataList.size() <= 0) {
            return 0;
        }
        return dataList.get(0) + factFucn1(new ArrayList<Integer> (dataList.subList(1, dataList.size())));
    }

    public static int factFucn2(int n) {
        if (n == 1) {
            return 1;
        }
        else if(n == 2) {
            return 2;
        }
        else if(n == 3) {
            return 4;
        }
        return factFucn2(n - 3) + factFucn2(n - 2) + factFucn2(n - 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            testData.add(i);
        }
        int result1 = factFucn1(testData);
        System.out.println(result1);

        int result2 = factFucn2(5);
        System.out.println(result2);
    }
}
