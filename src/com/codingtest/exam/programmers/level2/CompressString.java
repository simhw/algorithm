package com.codingtest.exam.programmers.level2;
public class CompressString {

    public int solution(String s) {
        int answer = 1001;

        // 문자열을 자르는 단위 k
        // 압축할 문자열 s가 매개변수로 주어질 때, 1개 이상 단위로 문자열을 잘라 압축한다.

        /**
         * 테스트 케이스 5
         * 입력 문자열 길이가 1일 경우 
         */
        
        if (s.length() < 2) 
            answer = 1;
        
        for (int k = 1; k < s.length() / 2 + 1; k++) {

            int len = 0;
            int cnt = 1;

            for (int i = 0; i < s.length(); i += k) {

                if (i + k + k > s.length()){
                    break;
                }

                // 문자열은 제일 앞부터 정해진 길이만큼 잘라야 합니다.
                System.out.println(s.substring(i, i + k) + " " + s.substring(i + k, i + k + k));

                if (s.substring(i, i + k).equals(s.substring(i + k, i + k + k))) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        // 중복하는 문자열 길이가 두자리수일 경우를 고려해 숫자의 길이를 더해준다.
                        len += Integer.toString(cnt).length();
                        len += k;
                        System.out.println("len " + len);
                        cnt = 1;
                    } else {
                        len += k;
                        System.out.println("len " + len);
                    }
                }
            }

            if (cnt > 1) {
                len += Integer.toString(cnt).length();
                len += k;
                // 탐색하지 않은 나머지 배열 
                len += s.length() % k;

            } else {
                len += k;
                // 탐색하지 않은 나머지 배열 
                len += s.length() % k;
            }
            System.out.println("total " + len);
            answer = answer < len ? answer : len;
        }
        return answer;
    }

    public static void main(String[] args) {
        CompressString compressString = new CompressString();
        compressString.solution("a");
    }
}
