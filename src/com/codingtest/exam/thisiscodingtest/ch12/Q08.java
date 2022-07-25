package com.codingtest.exam.thisiscodingtest.ch12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 문자열 재정렬
public class Q08 {
    static String S;

    static void input() {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLine();
        sc.close();
    }

    static void solution() {
        ArrayList<Character> result = new ArrayList<>();
        int value = 0;
        for (int i = 0; i < S.length(); i++) {
            // 함수를 사용하여 알파벳과 숫자를 구분
            if (Character.isAlphabetic(S.charAt(i))) {
                result.add(S.charAt(i));
            } else {
                value += S.charAt(i) - '0';
            }
        }
        Collections.sort(result);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }
        if (value != 0) {
            System.out.println(value);
        }
    }

    static void mysolution() {
        String str = "";
        int num = 0;
        for (int i = 0; i < S.length(); i++) {
            if ((S.charAt(i) - 'A') >= 0 && (S.charAt(i) - 'A') <= 25) {
                str += S.charAt(i);
            } else {
                num += S.charAt(i) - '0';
            }
        }
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);
        System.out.println(sorted + num);
    }

    public static void main(String[] args) {
        // K1KA5CB7
        input();
        solution();
    }
}
