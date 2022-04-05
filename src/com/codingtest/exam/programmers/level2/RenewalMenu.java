package com.codingtest.exam.programmers.level2;

import java.util.*;

public class RenewalMenu {
    private static HashMap<String, Integer> hashMap = new HashMap<>();
    private static String[] selected;
    private static List<String> order = new ArrayList<>();
    private static int M;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                order = Arrays.asList(orders[j].split(""));
                Collections.sort(order);
                M = course[i];
                selected = new String[M + 1];
                recFunc(1);
            }
            if (hashMap.size() == 0) continue;                
            int max = Collections.max(hashMap.values());
            for (String key : hashMap.keySet()) {
                if (max > 1 && max == hashMap.get(key)) {
                    arrayList.add(key);
                }
            } 
            hashMap = new HashMap<>();
        }
        arrayList.sort(Comparator.naturalOrder());

        String[] answer = new String[arrayList.size()];
        arrayList.toArray(answer);
      
        return answer;        
    }

    public void recFunc(int k) {
        // M 개를 전부 고른 경우 조건에 맞는 탐색을 한 가지 성공한 것이다.
        if (k == M + 1) {
            String str = "";
            for (int i = 1; i < M + 1; i++) {
                str += selected[i];
            }
            if (hashMap.get(str) == null) {
                hashMap.put(str, 1);
            } else {
                hashMap.put(str, hashMap.get(str) + 1);
            }
        } else {
            // 아직 M 개를 고르지 않은 경우 k 번째부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
            int start = order.indexOf(selected[k - 1]) + 1;
            for (int i = start; i < order.size(); i++) {
                selected[k] = order.get(i);
                recFunc(k + 1);
                selected[k] = null;
            }
        }
    }

    public static void main(String[] args) {
        RenewalMenu renewalMenu = new RenewalMenu();
        renewalMenu.solution(new String[] { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" }, new int[] { 2, 3, 5});
    }
}
