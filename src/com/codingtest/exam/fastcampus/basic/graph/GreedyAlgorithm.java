package com.codingtest.exam.fastcampus.basic.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm {
    public static void coinFunc(Integer price, ArrayList<Integer> coinList) {
        Integer totalCoinCnt = 0;
        for (int i = 0; i < coinList.size(); i++) {
            Integer coin = coinList.get(i);
            Integer cnt = 0;
            if (coin > price) continue;
            else {
                cnt = price / coin;
                totalCoinCnt += cnt;
                price = price % coin;
                System.out.println(coin + "원: " + cnt);
            }
        }
    }
    public static double knapsacFunc(Integer[][] objList, double capacity) {
        double totValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return (o2[1] / o2[0]) - (o1[1] - o1[0]);
            }
        });

        for (int i = 0; i < objList.length; i++) {
            if (capacity - (double)objList[i][0] > 0) {
                capacity -= (double)objList[i][0];
                totValue += (double)objList[i][1];
                System.out.print("무게: " + objList[i][0]);
                System.out.println(", 가치: " + objList[i][1]);
            }
            else{
                fraction = capacity / (double)objList[i][0];
                totValue += (double)objList[i][1] * fraction;
                System.out.print("무게: " + objList[i][0]);
                System.out.println(", 가치: " + objList[i][1]);
                break;
            }
         }
        return totValue;
    }
    public static void main(String[] args) {
//        ArrayList<Integer> coinList = new ArrayList<>();
//        coinList.addAll(Arrays.asList(500, 100, 50, 10));
//        coinFunc(4720, coinList);

        Integer[][] objList = {{10, 10}, {30, 5}, {20, 10}, {15, 12}, {25, 8}};
        double totalValue = knapsacFunc(objList, 40.0);
        System.out.println(totalValue);
    }
}
