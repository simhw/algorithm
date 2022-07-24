package com.codingtest.exam.thisiscodingtest.ch14;

import java.util.*;

// 실패율
// 2019 KAKAO BLIND RECRUITMENT
public class Q25 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Double> hashMap = new HashMap<Integer, Double>();

        int reach = stages.length;
        // 스테이지 번호를 1부터 N까지 증가시키며
        for (int stage = 1; stage < N + 1; stage++) {
            // 해당 스테이지에 머물러 있는 사람의 수 계산
            int cnt = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stage == stages[j]) cnt += 1;
            }
            // 실패율 계산
            // '스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수'
            double fail = 0;
            if (reach >= 1) {
                fail = (double) cnt / reach;
            }

            // 스테이지 번호, 실패율 원소 삽입
            hashMap.put(stage, fail);
            reach -= cnt;
        }
        // 실패율을 기준으로 각 스테이지를 내림차순 정렬
        List<Map.Entry<Integer, Double>> entries = new ArrayList<>(hashMap.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (int i = 0; i < N; i++) {
            answer[i] = entries.get(i).getKey();
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        Q25 q25 = new Q25();
        q25.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }
}
