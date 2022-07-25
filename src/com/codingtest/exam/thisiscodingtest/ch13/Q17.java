package com.codingtest.exam.thisiscodingtest.ch13;

// 경쟁적 전염

import java.util.*;

class Virus implements Comparable<Virus> {
    int type;
    int second;
    int x;
    int y;

    Virus(int type, int second, int x, int y) {
        this.type = type;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Virus o) {
        return this.type - o.type;
    }
}

public class Q17 {
    static int n, k, s, x, y;
    static int[][] arr;
    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static ArrayList<Virus> viruses = new ArrayList<Virus>();
    static Queue<Node> queue = new LinkedList<Node>();

    static void solution() {
        // 정렬 이후에 큐로 옮기기
        // 매초 번호가 낮은 종류의 바이러스부터 먼저 증식하기 때문
        Collections.sort(viruses);
        Queue<Virus> q = new LinkedList<>();
        for (int i = 0; i < viruses.size(); i++) {
            q.add(viruses.get(i));
        }

        while (!q.isEmpty()) {
            Virus virus = q.poll();
            // 정확히 s 만큼 초가 지나거나, 큐가 빌 때까지 반복
            if (virus.second == s) break;

            for (int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                // 아직 방문하지 않은 위치라면, 그 위치에 바이러스 넣기
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = virus.type;
                    q.add(new Virus(virus.type, virus.second + 1, nx, ny));
                }
            }
        }
        System.out.println(arr[x - 1][y - 1]);
    }

    static void mysolution() {
        for (int virus = 1; virus <= k; virus++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == virus) {
                        queue.add(new Node(i, j));
                    }
                }
            }
        }

        for (int i = 0; i < s; i++) {
            bfs();
        }
        System.out.println(arr[x - 1][y - 1]);
    }

    static void bfs() {
        Queue<Node> temp = new LinkedList<>();
        while (!queue.isEmpty()) {
            temp.add(queue.poll());
        }

        while (!temp.isEmpty()) {
            Node now = temp.poll();
            int virus = arr[now.x][now.y];

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = virus;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] != 0) {
                    viruses.add(new Virus(arr[i][j], 0, i, j));
                }
            }
        }
        s = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        sc.close();

        solution();
    }
}
