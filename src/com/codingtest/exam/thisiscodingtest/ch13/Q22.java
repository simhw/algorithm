package com.codingtest.exam.thisiscodingtest.ch13;

import java.util.*;

//블록 이동하기
//2020 KAKAO BLIND RECRUITMENT

class Robot {
    int x1;
    int y1;
    int x2;
    int y2;
    int distance;

    public Robot(int x1, int y1, int x2, int y2, int distance) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", distance=" + distance;
    }
}

public class Q22 {
    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        int n = board.length;
        int[][] arr = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                arr[i][j] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i + 1][j + 1] = board[i][j];
            }
        }

        // 시작 위치
        Queue<Robot> queue = new LinkedList<>();
        List<Robot> visited = new ArrayList<>();
        Robot start = new Robot(1, 1, 1, 2, 0);
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Robot robot = queue.poll();
            // (n, n) 위치에 로봇이 도달했다면, 거리 반환
            if ((robot.x1 == n && robot.y1 == n) || (robot.x2 == n && robot.y2 == n)) {
                System.out.println(robot.distance);
                return robot.distance;
            }
            // 현재 위치에서 이동할 수 있는 위치 확인
            List<Robot> nextRobots = getNextPos(robot, arr);
            for (int i = 0; i < nextRobots.size(); i++) {
                boolean check = true;
                robot = nextRobots.get(i);
                for (int j = 0; j < visited.size(); j++) {
                    if (robot.x1 == visited.get(j).x1 && robot.y1 == visited.get(j).y1
                            && robot.x2 == visited.get(j).x2 && robot.y2 == visited.get(j).y2) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    queue.add(robot);
                    visited.add(robot);
                }
            }
        }
        return 0;
    }

    public List<Robot> getNextPos(Robot robot, int[][] arr) {
        int nx1, ny1, nx2, ny2;
        // 반환 결과(이동 가능한 위치들)
        List<Robot> nextPos = new ArrayList<>();
        // 로봇이 상, 하, 좌, 우로 움직임(4가지)
        for (int i = 0; i < 4; i++) {
            nx1 = robot.x1 + dx[i];
            ny1 = robot.y1 + dy[i];
            nx2 = robot.x2 + dx[i];
            ny2 = robot.y2 + dy[i];
            // 이동하고자 하는 두 칸이 모두 비어 있다면
            if (arr[nx1][ny1] == 0 && arr[nx2][ny2] == 0) {
                nextPos.add(new Robot(nx1, ny1, nx2, ny2, robot.distance + 1));
            }
        }
        int[] hor = {-1, 1};
        int[] ver = {-1, 1};
        // 로봇이 가로인 경우
        if (robot.x1 == robot.x2) {
            // 위쪽으로 회전하거나, 아래쪽으로 회전
            for (int i = 0; i < 2; i++) {
                // 위쪽 혹은 아래쪽 두 칸이 모두 비어있다면
                if (arr[robot.x1 + hor[i]][robot.y1] == 0 && arr[robot.x2 + hor[i]][robot.y2] == 0) {
                    nextPos.add(new Robot(robot.x1, robot.y1, robot.x1 + hor[i], robot.y1, robot.distance + 1));
                    nextPos.add(new Robot(robot.x2, robot.y2, robot.x1 + hor[i], robot.y2, robot.distance + 1));
                }
            }
        }
        // 로봇이 세로인 경우
        if (robot.y1 == robot.y2) {
            // 왼쪽으로 회전하거나, 오른쪽으로 회전
            for (int i = 0; i < 2; i++) {
                // 왼쪽 혹은 오른쪽 두 칸이 모두 비어 있다면
                if (arr[robot.x1][robot.y1 + ver[i]] == 0 && arr[robot.x2][robot.y2 + ver[i]] == 0) {
                    nextPos.add(new Robot(robot.x1, robot.y1, robot.x1, robot.y1 + ver[i], robot.distance + 1));
                    nextPos.add(new Robot(robot.x2, robot.y2, robot.x2, robot.y2 + ver[i], robot.distance + 1));
                }
            }
        }
        // 현재 위치에서 이동할 수 있는 위치를 반환
        return nextPos;
    }

    public static void main(String[] args) {
        Q22 q22 = new Q22();
        q22.solution(new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}});
    }
}
