package com.codingtest.exam.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class NewsClustering {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        // 0. 초기화
        // 0-1. 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다.
        // 0-2. 대문자와 소문자의 차이는 무시한다.
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // 1. 입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다.
        for (int i = 0; i < str1.length() - 1; i++) {
            list1.add(str1.substring(i, i + 2));
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            list2.add(str2.substring(i, i + 2));
        }

        System.out.println(list1);
        System.out.println(list2);
        return answer;
    }
    public static void main(String[] args) {
        NewsClustering newsClustering = new NewsClustering();
        newsClustering.solution("FRANCE", "french");
    }
}
