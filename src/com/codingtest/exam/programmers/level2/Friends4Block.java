package com.codingtest.exam.programmers.level2;
import java.util.*;

public class Friends4Block {

    static char[][] arr;

    // 삭제할 블록의 좌표 반환
    public Set<String> is4Block(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {
                char block = board[i][j];
                if (block != '0' && block == board[i][j + 1] && block == board[i + 1][j] && block == board[i + 1][j + 1]) {
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

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '0') {
                    arr[i][j] = arr[i - 1][j];
                    arr[i - 1][j] = '0';
                }
            }
        }
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        Set<String> set;
        // 1. 초기화
        arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = board[i].toCharArray();
        }

        while (true) {
            // 2. 삭제될 블록 좌표 찾기
            set = is4Block(arr);
            answer += set.size();

            if (set.isEmpty()) {
                break;
            }

            // 3. 블록 삭제 및 빈 공간 채우기
            delete4Block(set);

//            for (int i = 0; i < arr.length; i++) {
//                System.out.println(Arrays.toString(arr[i]));
//            }
//            System.out.println();
        }
        return answer;
    }

    public static void main(String[] args) {
        Friends4Block friends4Block = new Friends4Block();
        friends4Block.solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});
    }
}
