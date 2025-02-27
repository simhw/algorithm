package com.codingtest.exam.baekjoon.gold;

import java.util.Scanner;
import java.util.Stack;

/**
 * 문자열 폭발
 * https://www.acmicpc.net/problem/9935
 */
public class P9935 {
    static String s;
    static String bomb;

    public static void solution() {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() >= bomb.length()) {
                boolean match = true;

                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        bomb = sc.nextLine();

        solution();
        sc.close();
    }
}
