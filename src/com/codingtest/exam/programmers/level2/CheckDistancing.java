package com.codingtest.exam.programmers.level2;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{x=" + x + ", y=" + y + "}";
    }
}

public class CheckDistancing {
    public int[] solution(String[][] places) {
        // 1. 출력 배열 1로 초기화 
        int[] answer = new int[places.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = 1;
        }

        for (int i = 0; i < places.length; i++) {
            Place: for (int j = 0; j < places.length; j++) {            // row = 5
                for (int k = 0; k < places.length; k++) {                // col = 5
                    // 1. P인 경우 
                    if (places[i][j].substring(k, k + 1).equals("P")) {
                        if (!adjacent(places[i], "P", new Node(j, k))) {
                            answer[i] = 0;
                            break Place;
                        }
                    }
                    // 2. O인 경우 
                    else if (places[i][j].substring(k, k + 1).equals("O")) {
                        if (!adjacent(places[i], "O", new Node(j, k))) {
                            answer[i] = 0;
                            break Place;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        return answer;
    }

    public boolean adjacent(String[] place, String ch, Node node) {

        int[] rows = new int[] { 0, -1, 0, 1 }; // x 좌상우하
        int[] cols = new int[] { -1, 0, 1, 0 }; // y 좌상우하
        int x, y;
        int cnt = 0;

        for (int i = 0; i < rows.length; i++) {
            x = node.x - rows[i];
            y = node.y - cols[i];
            // 1. 그래프 범위를 벗어난 경우 확인 
            if (x < 0 || y < 0 || x > place.length - 1 || y >= place.length) {
                continue;
            } else {
                // 2. 자기 원소가 P일 때 인접한 점에 다른 P 가 존재하는지 확인
                if (ch.equals("P") && place[x].substring(y, y + 1).equals("P")) {
                    return false;
                }      
                // 3. 자기 원소가 O일 때 인접 원소에 P가 1개 이하인지 확인 
                else if (ch.equals("O") && place[x].substring(y, y + 1).equals("P")) {
                    cnt++;
                    if (cnt > 1) return false; 
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckDistancing checkDistancing = new CheckDistancing();
        checkDistancing.solution(new String[][] {
                { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
                { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" },
                { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
                { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" },
                { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" }
        });
    }
}
