package com.codingtest.exam.thisiscodingtest.ch13;

// 괄호 변환
// 2020 카카오 신입 공채 1차
public class Q18 {
    public String solution(String p) {
        String answer = divideBalancedStr(p);
        System.out.println(answer);
        return answer;
    }

    // 문자열을 "균형잡힌" 괄호 문자열로 분리
    public String divideBalancedStr(String p) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (p.length() <= 0) {
            return "";
        }
        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        String u = "";
        String v = "";

        int count = 0;        // 왼쪽 괄호의 개수
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                count += 1;
            } else {
                count -= 1;
            }
            if (count == 0) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }
        return makeProperStr(u, v);
    }

    // "올바른" 괄호 문자열인지 판단
    public String makeProperStr(String u, String v) {
        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        if (u.startsWith("(")) {
            //   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u + divideBalancedStr(v);
        } else {
            // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
            //   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            //   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            //   4-3. ')'를 다시 붙입니다.
            String temp = "(";
            temp += divideBalancedStr(v);
            temp += ")";
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    temp += ')';
                } else {
                    temp += '(';
                }
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        Q18 q18 = new Q18();
        q18.solution(")()(()");
    }
}
