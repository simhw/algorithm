package com.codingtest.exam.programmers.level2;

public class CompressString {

    public int solution(String s) {
        int answer = 0;
        compress(1, s);
        return answer;
    }

    public int compress(int k, String s) {
        int len = s.length();
        int cnt = 0;

        for (int i = 0; i < s.length() - 1; i++) {

            String str = s.substring(i, i + k);
            String next = s.substring(i + k, (i + k) + k);

            System.out.println(str + " " + next);
            if (str.equals(next)) {
                cnt++;
            } else {
                // 축약된 길이 만큼 빼준다.
                System.out.println(cnt);
                len = len - (cnt * k) + 1;
                cnt = 0;
            }
        }
        // 문자열 길이 반환
        System.out.println("len " + len);
        return len;
    }

    public static void main(String[] args) {
        CompressString compressString = new CompressString();
        compressString.solution("aabbaccc");
    }
}
