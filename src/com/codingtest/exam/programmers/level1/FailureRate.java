package com.codingtest.exam.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class FailureRate {

    public int[] solution(int N, int[] stages) {

        int[] answer = new int[N];

        // 0. 초기화
        // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수

        int[] notClearPlayer = new int[N + 2];

        Stage[] stageList = new Stage[N + 1];

        for (int i = 0; i < stages.length; i++) {
            notClearPlayer[stages[i]] += 1;
        }

        // 1. 실패율 계산
        // 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수

        int reachedPlayer = stages.length;
        stageList[0] = new Stage(0, -1.0);

        for (int i = 1; i < stageList.length; i++) {

            System.out.println(notClearPlayer[i] + "/" + reachedPlayer);

            // ※ 예외 처리 
            // 마지막 스테이지에 아무도 도달하지 못한 경우 마지막 스테이지의 실패율은 0이다. 
            // 0 / 0
            
            if (reachedPlayer == 0) {
                stageList[i] = new Stage(i, 0.0);
            } else {
                stageList[i] = new Stage(i, (double) notClearPlayer[i] / reachedPlayer);
            }
            reachedPlayer -= notClearPlayer[i];
        }

        // 2. 정렬
        Arrays.sort(stageList, new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                if (o1.failRate < o2.failRate) {
                    return 1;
                } else if (o1.failRate == o2.failRate) {
                    if (o1.stage > o2.stage) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < answer.length; i++) {
            answer[i] = stageList[i].stage;
            System.out.print(answer[i] + " ");
        }
        return answer;
    }

    public static void main(String[] args) {
        FailureRate failureRate = new FailureRate();
        failureRate.solution(8, new int[] { 1, 2, 3, 3, 4, 6, 7 });
    }
}

class Stage {
    int stage;
    double failRate;

    Stage(int stage, double failRate) {
        this.stage = stage;
        this.failRate = failRate;
    }

    @Override
    public String toString() {
        return "stage: " + stage + ", failRate: " + failRate;
    }
}
