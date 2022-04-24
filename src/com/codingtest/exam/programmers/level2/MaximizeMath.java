package com.codingtest.exam.programmers.level2;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximizeMath {

    ArrayList<Long> results = new ArrayList<>();

    public long solution(String expression) {

        // 0. 숫자 기호 분리
        String[] numbers = expression.split("[^0-9]");
        String[] operators = expression.replaceAll("[0-9]", "").split("");
        ArrayList<String> list = new ArrayList<>();

        // 0. 중복 연산자 제거
        for (int i = 0; i < operators.length; i++) if (!list.contains(operators[i])) list.add(operators[i]);

        // 1. 연산될 수 있는 모든 식 탐색 및 계산
        expression(numbers, operators, list, 0, new String[list.size()], new boolean[list.size()]);

        // 2. 가장 큰 값 반환
        return Collections.max(results);
    }

    public void expression(String[] numbers, String[] operators, ArrayList<String> list, int k, String[] selected, boolean[] used) {
        // 탐색 종료 조건
        if (k == list.size()) {
            ArrayList<String> optlist = new ArrayList<>(Arrays.asList(operators));
            ArrayList<String> numlist = new ArrayList<>(Arrays.asList(numbers));
            int idx;
            long answer = 0;

            for (int i = 0; i < selected.length; i++) {
                idx = optlist.indexOf(selected[i]);
                while (idx != -1) {
                    answer = calculate(Long.parseLong(numlist.get(idx)), Long.parseLong(numlist.get(idx + 1)), selected[i]);
                    // System.out.println(numlist.get(idx) + selected[i] + numlist.get(idx + 1) + "=" + answer);
                    numlist.set(idx, answer + "");
                    numlist.remove(idx + 1);
                    optlist.remove(idx);
                    idx = optlist.indexOf(selected[i]);
                }
            }
            results.add((long) Math.abs(answer));
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (used[i]) {
                    continue;
                } else {
                    selected[k] = list.get(i);
                    used[i] = true;
                    expression(numbers, operators, list,k + 1, selected, used);
                    selected[k] = "";
                    used[i] = false;
                }
            }
        }
    }

    public long calculate(long a, long b, String opt) {
        if (opt.equals("+")) {
            return a + b;
        } else if (opt.equals("-"))  {
            return a - b;
        } else {
            return a * b;
        }
    }

    public static void main(String[] args) {
        MaximizeMath maximizeMath = new MaximizeMath();
        maximizeMath.solution("50*6-3*2");
    }
}
