package com.codingtest.exam.programmers.level1;

import java.util.Arrays;
import java.util.stream.Stream;

public class PreseKeyPad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        String left = "*", right = "#";
        String[][] keypad = new String[][]{
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
                {"*", "0", "#"}
        };

        int[] numIdx = new int[2], rightIdx = new int[2], leftIdx = new int[2];

        // 눌러야 할 숫자
        for (int num:numbers) {
            for (int i = 0; i < keypad.length; i++) {
                for (int j = 0; j < keypad[i].length; j++) {
                    if (keypad[i][j] == num+"") {
                        numIdx[0] = i;
                        numIdx[1] = j;
                    } else if (keypad[i][j] == left) {
                        leftIdx[0] = i;
                        leftIdx[1] = j;
                    } else if (keypad[i][j] == right) {
                        rightIdx[0] = i;
                        rightIdx[1] = j;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PreseKeyPad preseKeyPad = new PreseKeyPad();
        preseKeyPad.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");

    }
}
