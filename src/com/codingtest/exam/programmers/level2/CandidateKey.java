package com.codingtest.exam.programmers.level2;

import java.util.Arrays;

public class CandidateKey {
    static int N, M;
    static int[] selected;

    public int solution(String[][] relation) {
        int answer = 0;
        // 1. 유일성(uniqueness) : 릴레이션에 있는 모든 튜플에 대해 유일하게 식별되어야 한다.
        for (int i = 1; i < relation[i].length; i++) {
            N = relation[i].length;
            M = i;
            selected = new int[M];
            for (int j = 0; j < M; j++) selected[j] = -1;
            uniqueness(relation, 0);
        }
        // 2. 최소성(minimality) : 유일성을 가진 키를 구성하는 속성(Attribute) 중 하나라도 제외하는 경우 유일성이 깨지는 것을 의미한다.
        return answer;
    }

    // 1. 유일성(uniqueness)
    public void uniqueness(String[][] relation, int k) {
        if (k == M) {
            System.out.println(Arrays.toString(selected));
        } else {
            int col = selected[k] + 1;
            for (int i = col; i < N; i++) {
                selected[k] = i;
                uniqueness(relation, k + 1);
                selected[k] = -1;
            }
        }
    }

    // 2. 최소성(minimality)

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
