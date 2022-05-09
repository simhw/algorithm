package com.codingtest.exam.programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class CandidateKey {
    static int N, M;
    static int[] selected;

    static ArrayList<String> superkey = new ArrayList<>();

    public int solution(String[][] relation) {
        int answer = 0;
        // 1. 유일성(uniqueness) : 릴레이션에 있는 모든 튜플에 대해 유일하게 식별되어야 한다.
        for (int i = 0; i < relation[i].length; i++) {
            N = relation[i].length;
            M = i + 1;
            selected = new int[M];
            // 가능한 모든 어트리뷰트의 조합을 만든다.
            uniqueness(relation, 1);
        }

        System.out.println(superkey);
        // 2. 최소성(minimality) : 유일성을 가진 키를 구성하는 속성(Attribute) 중 하나라도 제외하는 경우 유일성이 깨지는 것을 의미한다.
        // 슈퍼 키 집합을 구한 후, 여기서 최소성을 만족하는 키들을 선택하여 후보 키 집합을 만들 수 있습니다.
        // 만약 어떤 슈퍼 키 X에 대해 X의 부분집합인 슈퍼 키 Y가 없다면 (X ⊃ Y인 슈퍼 키 Y가 없다면) X는 후보 키로 선택될 수 있습니다.
        return answer;
    }

    public void uniqueness(String[][] relation, int k) {
        if (k == M + 1) {
            // 어트리뷰트 조합에서 중복 튜플이 있는지 검사한다.(슈퍼 키 집합)
            Set<String> set = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                String key = "";
                for (int j = 0; j < selected.length; j++) key += relation[i][selected[j]];                 
                if(!set.add(key)) continue;
            }

            
            if(set.size() == relation.length) {
                String key = "";
                for (int i = 0; i < selected.length; i++) {
                    key += selected[i];
                }
                superkey.add(key);
            }
            
        } else {
            int start = (k == 1) ? 0 : selected[k - 2] + 1;
            for (int candidate = start; candidate < N; candidate++) {
                selected[k - 1] = candidate;
                uniqueness(relation, k + 1);
                selected[k - 1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        CandidateKey candidateKey = new CandidateKey();
        candidateKey.solution(new String[][] {
                { "100", "ryan", "music", "2" },
                { "200", "apeach", "math", "2" },
                { "300", "tube", "computer", "3" },
                { "400", "con", "computer", "4" },
                { "500", "muzi", "music", "3" },
                { "600", "apeach", "music", "2" }
        });
    }
}
