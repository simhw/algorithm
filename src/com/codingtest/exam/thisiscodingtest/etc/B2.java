package com.codingtest.exam.thisiscodingtest.etc;

import java.util.*;

// 암호 만들기 
public class B2 {
    static int l, c;
    static char[] chars;

    static List<String> candidate = new ArrayList<>();

    static void solution() {
        Arrays.sort(chars);

        // 길이가 l인 모든 암호 조합을 확인
        combination(new int[l + 1], 1);

        // 패스워드에 포함된 각 문자를 확인하며 모음의 개수를 세기
        for (int i = 0; i < candidate.size(); i++) {
            String str = candidate.get(i);
            int vowel = 0;
            for (int j = 0; j < l; j++) {
                char ch = str.charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowel += 1;
                }
            }
            // 최소 1개의 모음과 최소 2개의 자음이 있는 경우 출력
            if (vowel >= 1 && vowel <= l - 2) {
                System.out.println(str);
            }
        }
    }

    static void combination(int[] selected, int k) {
        // c개 중 l개를 모두 선택한 경우
        if (k == l + 1) {
            String str = "";
            int index = 0;
            for (int i = 1; i < l + 1; i++) {
                index = selected[i] - 1;
                str += (chars[index]);
            }
            candidate.add(str);
        } else {
            int start = selected[k - 1] + 1;
            for (int i = start; i < c + 1; i++) {
                selected[k] = i;
                combination(selected, k + 1);
                selected[k] = 0;
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
