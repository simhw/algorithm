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
            
            while(board[idx][move] == 0 && idx < board.length - 1) idx++;

            int popped = 0;
            if (basket.size() > 0) popped = basket.get(basket.size() - 1);
            
            if (popped == board[idx][move]) {
                answer += 2;
                basket.remove(basket.size() - 1);
                board[idx][move] = 0;   
            } else {
                basket.add(board[idx][move]);
                board[idx][move] = 0;   
            }    
        }
        return answer;
    }
    public static void main(String[] args) {
        ClawMachine clawMachine = new ClawMachine();
        int[][] board = new int[][]{
            {0,0,0,0,0},
            {0,0,1,0,3},
            {0,2,5,0,1},
            {4,2,4,4,2},
            {3,5,1,3,1}
        };
        int[] moves = new int[]{1,5,3,5,1,2,1,4};
        clawMachine.solution(board, moves);
    }
}