package com.codingtest.exam.programmers.level1;
import java.util.Arrays;
import java.util.Comparator;

class MoneyExchange {
    public int solution(int money, int[] costs) {
        int answer = 0;
        // 1. 초기화
        int[] currencies = {1, 5, 10, 50, 100, 500};
        int[][] objList = new int[6][2];

        for (int i = 0; i < costs.length; i++) {
            objList[i][0] = costs[i];
        }

        for (int i = 0; i < currencies.length; i++) {
            objList[i][1] = currencies[i];
        }

        Arrays.sort(objList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double x =  (o1[0] / o1[1] - o2[0] / o2[1]) * 1.0;
                if (x > 0.00001) return 1;
                else if (x < 0.00001) return -1;
                return 0;
            }
        });

        int cnt = 0;

        // 2. 생산 단가가 낮은 돈으로 최대한 많이 생산한다.
        for (int i = 0; i < objList.length; i++) {
            int price = objList[i][0]; System.out.println(price);
            if (money < price) continue;
            else {
                cnt = money / price;
                answer += price * cnt;
                money %= price;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MoneyExchange solution = new MoneyExchange();
        // Greedy Algorithm (탐욕 알고리즘)
        // 생산 비용이 적게 드는 동전을 선택하는 것이 최적의 선택이다.

        int[] costs = {1, 4, 99, 35, 50, 1000};
        int money = 4578;

        int answer = solution.solution(money, costs);
        System.out.println(answer);
    }
}