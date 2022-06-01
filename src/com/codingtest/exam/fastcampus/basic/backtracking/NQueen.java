package com.codingtest.exam.fastcampus.basic.backtracking;

import java.util.ArrayList;

public class NQueen {
    // Backtracking
    // 제약 조건 만족 문제에서 해를 찾기 위해 후보군에 제약 조건을 점직적으로 체크하다가,
    // 제약이 맞지 않으면 다른 루트로 바로 돌아가 시간을 절약하는 기법이다.

    public void nQueen(Integer n, Integer currentRow, ArrayList<Integer> currentCandidate) {
        if (n == currentRow) {
            System.out.println("Queen: " + currentCandidate);
            return;
        }
        // 한 행에는 하나의 퀸 밖에 위치할 수 없으므로 맨 위에 있는 행부터 퀸을 배치하고, 다음 행에 해당 퀸이 이동할 수 없는 위치를 찾아 퀸을 배치한다.
        // 만약 앞선 행에 배치한 퀸으로 인해 다음 행에 해당 퀸들이 이동할 수 위치가 없을 경우에는, 더 이상 퀸을 배치하지 않고 이전 행의 퀸 배치를 바꾼다.
        for (int i = 0; i < n; i++) {
            if (this.isPromising(currentCandidate, i) == true) {
                currentCandidate.add(i);
                System.out.println("currentCandidate: " + currentCandidate);
                this.nQueen(n, currentRow + 1, currentCandidate);
                // pruning
                currentCandidate.remove(currentCandidate.size() - 1);
            }
        }
    }

    public boolean isPromising(ArrayList<Integer> candidate, Integer currentCol) {
        Integer currentRow = candidate.size();
        Integer queenCol;
        for (int i = 0; i < currentRow; i++) {
            queenCol = candidate.get(i);
            // 수직, 대각선 위치를 체크해준다.
            if (currentCol - queenCol == 0 || Math.abs(queenCol - currentCol) == currentRow - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.nQueen(4, 0, new ArrayList<Integer>());
    }
}
