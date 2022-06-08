package com.codingtest.exam.programmers.level3;

import java.util.Arrays;

public class LockAndKey {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        boolean match = true;

        // 최대 4 번까지 배열을 회전시키면서 가능한 경우를 모두 탐색
        for (int i = 0; i < 4; i++) {
            match = true;
            for (int j = 0; j < lock.length; j++) {
                if (Math.abs(key[0][j] - lock[lock.length - 1][j]) != 1) {
                    match = false;
                    break;
                }
            }
            if (match) {
                break;
            } else {
                key = turnKey(key);
            }
        }

        // for (int i = 0; i < key.length; i++) {
        //     System.out.println(Arrays.toString(key[i]));
        // }
        // System.out.println("match " + match);
        
        // 자물쇠 영역 내에서는 열쇠의 돌기(1) 부분과 자물쇠의 홈(0) 부분이 정확히 일치

        // lock 배열을 가로, 세로 길이가 3배인 새로운 배열의 중앙 부분으로 이동 
        int[][] triple = new int[lock.length * 3][lock.length * 3];
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                triple[lock.length + i][lock.length + j] = lock[i][j];
            }
        }

        int count = key.length - 1;
        for (int i = 0; i < lock.length + (key.length - 1); i++) {
            for (int j = 0; j < lock.length + (key.length - 1); j++) {
                // x, y 좌표 
                if(moveKey(key, triple, (lock.length - count) + i, (lock.length - count) + j)) {

                }
            }    
        }
        return answer;
    }
    public boolean moveKey(int[][] key, int[][] triple, int x, int y) {
        
        return true;
    }


    // 시계 방향으로 90 도씩 회전
    public int[][] turnKey(int[][] key) {
        int m = key.length;
        int[][] turned = new int[m][m];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                turned[i][m - (j + 1)] = key[j][i];
            }
        }
        return turned;
    }

    public static void main(String[] args) {
        LockAndKey lockAndKey = new LockAndKey();
        lockAndKey.solution(new int[][] { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } },
                new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } });
    }
}