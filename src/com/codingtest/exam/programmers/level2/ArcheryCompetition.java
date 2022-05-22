package com.codingtest.exam.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ArcheryCompetition {

    static int max = -1;
    static int[] maxArr;

    public int[] solution(int n, int[] info) {
        // 각 점수를 아예 안 맞추거나 어피치보다 1발을 더 맞히는 경우로 각 점수(10점 ~ 0점)마다 2가지(총 2,048가지)를 완전 탐색한다.
        recursion(10, new int[11], n, info);
        return max > -1 ? maxArr : new int[]{-1} ;
    }

    public void recursion(int k, int[] selected, int n, int[] info) {
        // 모든 점수 탐색 완료 조건
        if (k == -1) {
            int apeach = 0; int lion = 0;
            // 나머지 과녁 점수를 모두 0 발 맞춘 것으로 처리
            if (n < 0) {
                return;
            } else {
                selected[10] += n;
            }

            for (int i = 0; i < selected.length; i++) {
                if (selected[i] == 0 && info[i] == 0) {
                    continue;
                } else if (selected[i] > info[i]) {
                    lion += (10 - i);
                } else {
                    apeach += (10 - i);
                }
            }

            if (lion > apeach) {
                if (lion - apeach == max && compare(maxArr, selected)) {
                    return;
                } else if (lion - apeach >= max) {
                    max = lion - apeach;
                    maxArr = new int[selected.length];
                    for (int i = 0; i < selected.length; i++) {
                        maxArr[i] = selected[i];
                    }
                }
            }
        } else {
            // k 점을 맞추는 경우
            selected[10 - k] = info[10 - k] + 1;
            recursion(k - 1, selected, n - selected[10 - k], info);

            // k 점을 안 맞추는 경우
            selected[10 - k] = 0;
            recursion(k - 1, selected, n, info);
        }
    }

    // 가장 낮은 점수를 더 많이 맞힌 점수 배열 반환
    public boolean compare(int[] arr1, int[] arr2) {
        for (int i = arr1.length - 1; i > 0; i--) {
            if (arr1[i] - arr2[i] == 0) {
                continue;
            } else if (arr1[i] - arr2[i] > 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArcheryCompetition archeryCompetition = new ArcheryCompetition();
        archeryCompetition.solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1});
    }

}