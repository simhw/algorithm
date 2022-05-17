package com.codingtest.exam.programmers.level2;

import java.util.*;
// 1. 유일성(uniqueness) : 릴레이션에 있는 모든 튜플에 대해 유일하게 식별되어야 한다.
// 2. 최소성(minimality) : 유일성을 가진 키를 구성하는 속성(Attribute) 중 하나라도 제외하는 경우 유일성이 깨지는 것을 의미한다.
// 슈퍼 키 집합을 구한 후, 여기서 최소성을 만족하는 키들을 선택하여 후보 키 집합을 만들 수 있습니다.
// 만약 어떤 슈퍼 키 X에 대해 X의 부분집합인 슈퍼 키 Y가 없다면 (X ⊃ Y인 슈퍼 키 Y가 없다면) X는 후보 키로 선택될 수 있습니다.

public class CandidateKey {
    static List<String> subsetList = new ArrayList<>();
    static List<String> uniqueList = new ArrayList<>();

    public int solution(String[][] relation) {
        List<Set<String>> answer = new ArrayList<>();

        // 1. 가능한 모든 어트리뷰트의 조합을 만든다.
        int n = relation[0].length;
        for (int i = 0; i < n; i++) {
            getAllSubset(n, i, -1, 0, "");
        }

        // 2. 어트리뷰트 조합에서 중복 튜플이 있는지 검사한다. (슈퍼키)
        getAllUniqueSubset(relation);

        // 3. 슈퍼키 집합 중에서 최소성을 만족하는 키들을 선택한다. (후보키)
        for (String subset : uniqueList) {
            boolean check = true;
            Set<String> set = new HashSet<>(Arrays.asList(subset.split("")));
            for (int i = 0; i < answer.size(); i++) {
                if (set.containsAll(answer.get(i))) {
                    check = false;
                }
            }
            if (check) {
                answer.add(set);
            }
        }
        System.out.println(answer);
        return answer.size();
    }

    public void getAllSubset(int n, int r, int k, int start, String str) {
        if (k == r) {
            subsetList.add(str);
        } else {
            for (int i = start; i < n; i++) {
                str = str + i;
                getAllSubset(n, r, k + 1, i + 1, str);
                str = str.substring(0, k + 1);
            }
        }
    }

    public void getAllUniqueSubset(String[][] relation) {
        for (String subset : subsetList) {
            boolean unique = true;
            Set<String> rowSet = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                String row = "";
                for (String j : subset.split("")) {
                    row += relation[i][Integer.parseInt(j)];
                }
                if (rowSet.contains(row)) {
                    unique = false;
                    break;
                }
                rowSet.add(row);
            }
            if (unique) {
                uniqueList.add(subset);
            }
        }
    }


    public static void main(String[] args) {
        CandidateKey candidateKey = new CandidateKey();
        candidateKey.solution(new String[][] {
                {"a","1","aaa","c","ng"},
                {"a","1","bbb","e","g"},
                {"c","1","aaa","d","ng"},
                {"d","2","bbb","d","ng"}
        }
        );
    }
}
