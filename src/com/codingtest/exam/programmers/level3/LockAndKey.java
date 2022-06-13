package com.codingtest.exam.programmers.level3;

public class LockAndKey {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int n = lock.length; // 자물쇠 크기
        int m = key.length; // 키 크기

        // 자물쇠 크기를 가로, 세로 길이 3 배로 변환
        int[][] board = new int[n * 3][n * 3];

        // 새로운 자물쇠의 중앙 부분에 기존의 자물쇠 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i + n][j + n] = lock[i][j];
            }
        }

        // 최대 4 번까지 배열을 회전시키면서 가능한 경우를 모두 탐색
        for (int count = 0; count < 4; count++) {
            key = turn(key);
            
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
            
                    // 자물쇠에 열쇠 끼워 넣기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            board[x + i][y + j] += key[i][j];
                        }
                    }
                  
                    // 새로운 자물쇠에 열쇠가 정확히 들어맞는지 검사
                    if (check(board)) {
                        answer = true;
                    }

                    // 자물쇠에 열쇠 다시 빼기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            board[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        
        return answer;
    }

    // 자물쇠의 중간 부분이 모두 1 인지 확인
    public boolean check(int[][] board) {
        int len = board.length / 3;
        for (int i = len; i < len * 2; i++) {
            for (int j = len; j < len * 2; j++) {
                if (board[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // 시계 방향으로 90 도 회전
    public int[][] turn(int[][] key) {
        int n = key.length; 
        int[][] turned = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                turned[j][n - (i + 1)] = key[i][j];
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