package com.codingtest.exam.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ModifyBracket {
    public String solution(String p) {
        String answer = "";
        List<String> w = new ArrayList<>(Arrays.asList(p.split("")));
        w = separate(w);
        for (int i = 0; i < w.size(); i++) {
            answer += w.get(i);
        }
        System.out.println(answer);
        return answer;
    }

    public List<String> separate(List<String> w) {
        List<String> u, v;
        Stack<String> stack = new Stack<>();
        List<String> added = new ArrayList<String>();

        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (w.size() == 0) {
            return w;
        }
        else {
            stack.add(w.get(0));
            int i = 1;
            while (!stack.empty()) {
                if (stack.peek().equals(w.get(i))) {
                    stack.add(w.get(i));
                } else {
                    stack.pop();
                }
                i++;  
            }

            // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
            u = w.subList(0, i);
            v = w.subList(i, w.size());

            System.out.println("u " + u);
            System.out.println("v " + v);
 
            if (u.get(0).equals("(")) {  
                // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.   
                // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
                added.addAll(u);
                added.addAll(separate(v));
            } else {
                // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
                // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
                List<String> list = new ArrayList<String>();

                // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
                // 4-3. ')'를 다시 붙입니다. 
                // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
                added.addAll(u);
                added.addAll(v);

                // 4-5. 생성된 문자열을 반환합니다.
            }
            System.out.println("addAll " + added);
            return added;
        }
    }

    public static void main(String[] args) {
        ModifyBracket modifyBracket = new ModifyBracket();
        modifyBracket.solution("()))((()");
    }
}