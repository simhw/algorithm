package com.codingtest.exam.programmers.level2;
public class CompressString {

    public int solution(String s) {
        int answer = 1001;

        // 문자열을 자르는 단위 k
        // 압축할 문자열 s가 매개변수로 주어질 때, 1개 이상 단위로 문자열을 잘라 압축한다.

        for (int k = 1; k < s.length() / 2 + 1; k++) {

            int len = 0;
            int cnt = 0;

            for (int i = 0; i < s.length(); i += k) {

                if (i + k + k > s.length())
                    break;

                // 문자열은 제일 앞부터 정해진 길이만큼 잘라야 합니다.
                String str1 = s.substring(i, i + k);
                String str2 = s.substring(i + k, i + k + k);

                System.out.println(str1 + " " + str2);

                if (str1.equals(str2)) {
                    cnt++;
                } else {
                    if (cnt > 0) {
                        len += Integer.toString(cnt).length();
                        len += k;
                        System.out.println("len " + len);
                        cnt = 0;
                    } else {
                        len += k;
                        System.out.println("len " + len);

                    }
                }
            }

            if (cnt > 0) {
                len += Integer.toString(cnt).length();
                len += k;
            } else {
                len += k;
                // 탐색하지 않은 나머지 배열 
                len += s.length() % k;
            }
            System.out.println("len " + len);
            answer = answer < len ? answer : len;

        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        CompressString compressString = new CompressString();
        compressString.solution("aabbaccc");
    }
}
