package com.codingtest.exam.thisiscodingtest.ch12;

import java.util.*;

// 기둥과 보 설치

class Element implements Comparable<Element> {
    int x;
    int y;
    int a;

    Element(int x, int y, int a) {
        this.x = x;
        this.y = y;
        this.a = a;
    }

    @Override
    public int compareTo(Element e) {
        //  x 좌표 기준으로 오름차순
        if (this.x > e.x) {
            return 1;
        }
        // x 좌표가 같을 경우 y 좌표 기준으로 오름차순
        else if (this.x == e.x) {
            // x, y 좌표가 모두 같은 경우 기둥이 보보다 앞
            if (this.y == e.y) {
                return this.a - e.a;
            } else {
                return this.y - e.y;
            }
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Element{" + "x=" + x + ", y=" + y + ", a=" + a + '}';
    }
}

public class Q12 {
    public boolean possible(List<List<Integer>> info) {
        for (int i = 0; i < info.size(); i++) {
            int x = info.get(i).get(0);
            int y = info.get(i).get(1);
            int stuff = info.get(i).get(2);
            // 기둥 조건
            if (stuff == 0) {
                boolean possible = false;
                // 기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
                if (y == 0) possible = true;
                for (int j = 0; j < info.size(); j++) {
                    List<Integer> temp = info.get(j);
                    if (x - 1 == temp.get(0) && y == temp.get(1) && temp.get(2) == 1) possible = true;
                    if (x == temp.get(0) && y == temp.get(1) && temp.get(2) == 1) possible = true;
                    if (x == temp.get(0) && y == temp.get(1) + 1 && temp.get(2) == stuff) possible = true;
                }
                if (!possible) return false;
            }
            // 보 조건
            if (stuff == 1) {
                boolean possible = false;
                boolean left = false;
                boolean right = false;
                // 한쪽 끝부분이 기둥 위에 있거나, 양쪽 끝부분이 다른 보와 동시에 연결
                for (int j = 0; j < info.size(); j++) {
                    List<Integer> temp = info.get(j);
                    if (x == temp.get(0) && y - 1 == temp.get(1) && temp.get(2) == 0) possible = true;
                    if (x + 1 == temp.get(0) && y - 1 == temp.get(1) && temp.get(2) == 0) possible = true;
                    if (x - 1 == temp.get(0) && y == temp.get(1) && temp.get(2) == 1) left = true;
                    if (x + 1 == temp.get(0) && y == temp.get(1) && temp.get(2) == 1) right = true;
                }
                if (left && right) possible = true;
                if (!possible) return false;
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int stuff = build_frame[i][2];
            int operate = build_frame[i][3];
            // 삭제하는 경우
            if (operate == 0) {
                for (int j = 0; j < answer.size(); j++) {
                    List<Integer> temp = answer.get(j);
                    if (x == temp.get(0) && y == temp.get(1) && stuff == temp.get(2)) {
                        answer.remove(j);
                        break;
                    }
                }
                if (!possible(answer)) {
                    answer.add(new ArrayList<Integer>(Arrays.asList(x, y, stuff)));
                }
            }
            // 설치하는 경우
            if (operate == 1) {
                answer.add(new ArrayList<Integer>(Arrays.asList(x, y, stuff)));
                if (!possible(answer)) {
                    answer.remove(answer.size() - 1);
                }
            }
        }

        // 최종 구조물 정렬
        List<Element> list = new ArrayList<>();
        for (int i = 0; i < answer.size(); i++) {
            list.add(new Element(answer.get(i).get(0), answer.get(i).get(1), answer.get(i).get(2)));
        }
        Collections.sort(list);

        // 배열로 바꾸어 반환
        int[][] elements = new int[list.size()][3];
        for (int i = 0; i < elements.length; i++) {
            elements[i][0] = list.get(i).x;
            elements[i][1] = list.get(i).y;
            elements[i][2] = list.get(i).a;
        }
        return elements;
    }

    public static void main(String[] args) {
        Q12 q12 = new Q12();
        q12.solution(5, new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}});
    }
}
