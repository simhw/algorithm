package com.codingtest.exam.programmers.level1;

import java.util.ArrayList;

/**
 * ClawMachine
 */
public class ClawMachine {
    public int solution(int[][] board, int[] moves) {

        int answer = 0;
        ArrayList<Integer> basket = new ArrayList<>();
        int move, idx;

        for (int i = 0; i < moves.length; i++) {
            move = moves[i] - 1;
            idx = 0;

            while (board[idx][move] == 0 && idx < board.length - 1) idx++;

            int popped = 0;
            if (basket.size() > 0) {
                popped = basket.get(basket.size() - 1);
            }
            /**
             빈 board 을 peek 하는 경우 런타임 에러 발생
             인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.
             */
            if (board[idx][move] == 0) {
                continue;
            }
            // peek
            else if (popped == board[idx][move]) {
                answer += 2;
                basket.remove(basket.size() - 1);
                board[idx][move] = 0;
            }
            // add
            else {
                basket.add(board[idx][move]);
                board[idx][move] = 0;
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        ClawMachine clawMachine = new ClawMachine();
        int[][] board = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 2, 1, 0, 0},
                {0, 2, 1, 0, 0},
                {0, 2, 1, 0, 0}
        };
        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};
        clawMachine.solution(board, moves);
    }
}