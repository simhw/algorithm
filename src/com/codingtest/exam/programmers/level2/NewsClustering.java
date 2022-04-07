package com.codingtest.exam.programmers.level2;

import java.util.ArrayList;

public class NewsClustering {
    public int solution(String str1, String str2) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        // 0. 초기화
        // 0-1. 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다.
        // 0-2. 대문자와 소문자의 차이는 무시한다.
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // 1. 입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다.
        for (int i = 0; i < str1.length() - 1; i++) {
            if (str1.substring(i, i + 2).matches("^[A-Z]*$")) {
                list1.add(str1.substring(i, i + 2));
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            if (str2.substring(i, i + 2).matches("^[A-Z]*$")){            
                list2.add(str2.substring(i, i + 2));
            }
        }

        System.out.println(list1);
        System.out.println(list2);

        // 2. 자카드 유사도 
        // 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의된다.

        if (list1.size() == 0 && list2.size() == 0) {
            return 65536;
        } else {
            int intersection = 0, union = 0;
            for (String str : list1) {
                if (list2.indexOf(str) != -1) {
                    intersection++;
                }
            }
            
            list1.addAll(list2);
            union = list1.size() - intersection;
            double similarity = (double)intersection / (double)union;
            return  (int)similarity * 65536;
        }
    }

    public static void main(String[] args) {
        NewsClustering newsClustering = new NewsClustering();
        newsClustering.solution("E=M*C^2", "e=m*c^2");
    }
}

// 테스트 4 〉	실패 (8.29ms, 75.9MB)
// 테스트 7 〉	실패 (1.06ms, 72.5MB)
// 테스트 9 〉	실패 (0.90ms, 73.4MB)
// 테스트 10 〉	실패 (1.67ms, 74.6MB)
// 테스트 11 〉	실패 (3.37ms, 77.7MB)