package com.codingtest.exam.thisiscodingtest.ch12;

// 문자열 압축
public class Q09 {
    public int solution(String s) {
        final int len = s.length();
        int answer = s.length();

        // 압축 단위는 1부터 문자열 길이의 절반까지
        for (int step = 1; step <= len / 2; step++) {
            String compressed = "";
            // 앞에서부터 step만큼의 문자열 추출
            String prev = s.substring(0, step);
            int cnt = 1;

            // 단위(step) 크기만큼 증가시키며 이전 문자열과 비교
            for (int i = step; i < len; i += step) {
                String sub = "";
                for (int j = i; j < i + step; j++) {
                    if (j < len) sub += s.charAt(j);
                }

                // 이전 상태와 동일하다면 압축 횟수(count) 증가
                if (prev.equals(sub)) {
                    cnt += 1;
                }
                // 다른 문자열이 나왔다면(더 이상 압축하지 못하는 경우라면)
                else {
                    compressed += (cnt >= 2) ? cnt + prev : prev;
                    sub = "";
                    for (int j = i; j < i + step; j++) {
                        if (j < len) sub += s.charAt(j);
                    }
                    // 다시 상태 초기화
                    prev = sub;
                    cnt = 1;
                }
            }
            // 남아있는 문자열에 대해서 처리
            compressed += (cnt >= 2) ? cnt + prev : prev;
            System.out.println(compressed);
            // 만들어지는 압축 문자열이 가장 짧은 것이 정답
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }

    public static void main(String[] args) {
        Q09 q09 = new Q09();
        q09.solution("abcabcdede");
    }
}
