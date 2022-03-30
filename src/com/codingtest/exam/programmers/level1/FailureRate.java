package com.codingtest.exam.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class FailureRate {

    public int[] solution(int N, int[] stages) {

        int[] answer = new int[N];

        // 0. 초기화
        // 스테이지별 클리어하지 못한 플레이어 수 초기화

        int stage;
        Stage[] stageList = new Stage[N + 1];
        for (int i = 0; i < stages.length; i++) {
            stage = stages[i];
            if (stage > N)
                continue;
            else {
                if (stageList[stage] == null) {
                    stageList[stage] = new Stage(stage);
                    stageList[stage].reachedPlayer = 1;
                } else {
                    stageList[stage].reachedPlayer += 1;
                }
            }
        }

        // 1. 실패율 계산
        // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수

        int reachedPlayer = stages.length;

        for (int i = 0; i < stageList.length; i++) {
            
            if (stageList[i] == null) {
                if (i == 0) {
                    stageList[i] = new Stage(i);
                    stageList[i].failRate = -1;
                } else stageList[i] = new Stage(i);
            } else {
                // 이전 스테이지를 통과한 플레이어들을 빼준다.
                reachedPlayer -= stageList[i - 1].reachedPlayer;
                stageList[i].failRate = (stageList[i].reachedPlayer * 1.0) / reachedPlayer;
            }
        }

        // 2. 정렬
        Arrays.sort(stageList, new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                if (o1.failRate < o2.failRate) return 1;
                else if (o1.failRate == o2.failRate) {
                    if (o1.stage > o2.stage) return 1;
                    else return -1;  
                } 
                else return -1;
            }
        });

        for (int i = 0; i < answer.length; i++) {
            answer[i] = stageList[i].stage;
        }
        return answer;
    }

    public static void main(String[] args) {
        FailureRate failureRate = new FailureRate();
        failureRate.solution(5, new int[] { 2, 1, 2, 6, 2, 4, 3, 3 });
    }
}

class Stage {
    int stage;
    int reachedPlayer;
    double failRate;

    Stage(int stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        return "stage: " + stage + ", reachedPlayer: " + reachedPlayer + ", failRate: " + failRate;
    }
}
