package com.codingtest.exam.baekjoon.silver;

import java.io.*;
import java.util.Stack;

/**
 * 에디터
 * https://www.acmicpc.net/problem/1406
 */
public class P1406 {
    static String s;
    static int n;
    static String[] commands;

    public static void solution() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char ch : s.toCharArray()) {
            left.push(ch);
        }

        for (String command : commands) {
            switch (command) {
                // L: 커서를 왼쪽으로 한 칸 옮김
                case "L":
                    if (!left.empty()) {
                        right.push(left.pop());
                    }
                    break;
                // D: 커서를 오른쪽으로 한 칸 옮김
                case "D":
                    if (!right.empty()) {
                        left.push(right.pop());
                    }
                    break;
                // B: 커서 왼쪽에 있는 문자를 삭제함
                case "B":
                    if (!left.empty()) {
                        left.pop();
                    }
                    break;
                // P $: $라는 문자를 커서 왼쪽에 추가함
                default:
                    char c = command.split(" ")[1].charAt(0);
                    left.push(c);
                    break;
            }
        }

        for (char ch : left) {
            bw.write(ch);
        }

        while (!right.empty()) {
            bw.write(right.pop());
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        n = Integer.parseInt(br.readLine());

        commands = new String[n];

        for (int i = 0; i < n; i++) {
            commands[i] = br.readLine();
        }

        solution();
        br.close();
    }
}
