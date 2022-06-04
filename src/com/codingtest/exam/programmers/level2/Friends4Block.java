package com.codingtest.exam.programmers.level2;
import java.util.*;

public class Friends4Block {
    static char[][] arr;

    public Set<String> is4Block(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {
                char block = board[i][j];
                if (block != '0' && block == board[i][j + 1] && block == board[i + 1][j] && block == board[ i + 1][j + 1]) {
                    set.add(i + " " + j);
                    set.add(i + " " + (j + 1));
                    set.add((i + 1) + " " + j);
                    set.add((i + 1) + " " + (j + 1));
                }
            }
        }
        return set;
    }

    public void delete4Block(Set<String> set) {
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String[] coordinate = iterator.next().split(" ");
            int x = Integer.parseInt(coordinate[0]);
            int y = Integer.parseInt(coordinate[1]);
            arr[x][y] = '0';
        }


        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '0') {
                    for (int k = i - 1; k >= 0 ; k--) {
                        if (arr[k][j] >= 'A' && arr[k][j] <= 'Z') {
                            arr[i][j] = arr[k][j];
                            arr[k][j] = '0';
                            break;
                        }
                    }
                }
            }
        }
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        Set<String> set;
        arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = board[i].toCharArray();    // 1. 초기화
        }

        while (true) {
            set = is4Block(arr);    // 2. 삭제될 블록 좌표 찾기
            answer += set.size();

            if (set.isEmpty()) {
                break;
            }

            delete4Block(set);  // 3. 블록 삭제 및 빈 공간 채우기
        }
        return answer;
    }

    public static void main(String[] args) {
        Friends4Block friends4Block = new Friends4Block();
        friends4Block.solution(5, 6, new String[]{"AAAAAA", "BBAATB", "BBAATB", "JJJTAA", "JJJTAA"});
    }
}
