package com.codingtest.exam.programmers;

public class Lotto {

    public int[] solution(int[] lottos, int[] win_nums) {
        System.out.println("solutio start!!! ");

        int correct = 0;
        int zero = 0;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero++;
                continue;
            }
            else {
                for (int j = 0; j < lottos.length; j++) {
                    if (lottos[i] == win_nums[j]) {
                        correct++;
                        System.out.println("correct: " + correct);
                    }
                }
            }
        }


        int highest = 0;
        int lowest = 0;

        // 순위
        if (correct != 0) {
            highest = correct + zero;
            lowest = correct;
            System.out.println("highest: " + highest);
            System.out.println("lowest: " + lowest);
        } else {
            // correct = 0, zero = 0
            if (zero == 0) {
                highest = 1;
                lowest = 1;
                System.out.println("highest: " + highest);
                System.out.println("lowest: " + lowest);
            }

            // correct = 0, zero = 6
            highest = 6;
            lowest = 1;
            System.out.println("highest: " + highest);
            System.out.println("lowest: " + lowest);
        }

        int answer[] = new int[2];

        answer[0] = 7 - highest;
        answer[1] = 7 - lowest;
        return answer;
}

    public static void main(String[] args) {
        Lotto lotto = new Lotto();

        int[] lottos = {44, 32, 2, 3, 7, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] answer = lotto.solution(lottos, win_nums);

        System.out.println(answer[0]);
        System.out.println(answer[1]);

    }

}
