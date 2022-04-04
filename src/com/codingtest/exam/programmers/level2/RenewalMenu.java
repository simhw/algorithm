package com.codingtest.exam.programmers.level2;

import java.util.HashMap;

public class RenewalMenu {
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static String[] selected;
    static String[] order;
    static int M;

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < course.length; j++) {
                selected = new String[course[j] + 1];
                order = orders[i].toUpperCase().split("");
                M = course[j];
                recFunc(1);
                System.out.println(hashMap.toString());
            }
        }
        return answer;
    }
    public void recFunc(int k) {
        // 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다. 
        // 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.
        if (k == M + 1) {
            String str = null;
            for (int i = 1; i < M + 1; i++) {
                 str.concat(selected[i]);
            }
            hashMap.put(str, 0);
        }
        else {
            for (int i = 0; i < order.length; i++) {
                selected[k] = order[i];
                recFunc(k + 1);
                selected[k] = null;
            }
        }
    }

    public static void main(String[] args) {
        RenewalMenu renewalMenu = new RenewalMenu();
        renewalMenu.solution(new String[]{"XYZ"}, new int[]{2});
    }
}
