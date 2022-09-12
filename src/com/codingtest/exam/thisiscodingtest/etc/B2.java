package com.codingtest.exam.thisiscodingtest.etc;

import java.util.*;

// 암호 만들기 
public class B2 {
    static int l, c;
    static char[] chars;

    static void solution() {
        Arrays.sort(chars);
        combination(new int[c], 0);
    }

    // c개 중 l개 선택
    static void combination(int[] selected, int k) {
        if (k == l) {
            System.out.println(Arrays.toString(selected));
        } else {
            int start = selected[k - 1];
            for (int i = start; i < c; i++) {

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();

        chars = new char[c];
        for (int i = 0; i < c; i++) {
            char ch = sc.next().charAt(0);
            chars[i] = ch;
        }

        solution();
        sc.close();
    }
}
