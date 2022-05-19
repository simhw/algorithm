package com.codingtest.exam.programmers.level2;

public class ArcheryCompetition {
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        int[] selected = new int[info.length];
        // 11 개 과녁 점수 중 어피치보다 1발을 더 맞추거나 0발 맞추거나  
        // 2의 11승 = 1,024 가지 
        
        int binary = 1;
        for (int i = 0; i < 11; i++) {
            binary *= 2;
        }
        System.out.println(binary);
        return answer;
    }
    public void recursion() {

    }
    public static void main(String[] args) {
        ArcheryCompetition archeryCompetition = new ArcheryCompetition();
        archeryCompetition.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
    }
    
}