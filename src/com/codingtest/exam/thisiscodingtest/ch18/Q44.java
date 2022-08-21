package com.codingtest.exam.thisiscodingtest.ch18;

// 행성 터널 
import java.util.*;

class Edge implements Comparable<Edge> {
    private int a;
    private int b;
    private int distance;

    public Edge(int a, int b, int distance) {
        this.a = a;
        this.b = b;
        this.distance = distance;
    }

    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance)
            return -1;
        return 1;
    }

    public String toString() {
        return "{a:" + this.a + ", b:" + this.b + ", dist:" + this.distance + "}";
    }
}

class Position implements Comparable<Position> {
    private int point;
    private int index;

    public Position(int point, int index) {
        this.point = point;
        this.index = index;
    }

    public int getPoint() {
        return this.point;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public int compareTo(Position other) {
        if (this.point == other.point) {
            return Integer.compare(this.index, other.index);
        }
        return Integer.compare(this.point, other.point);
    }

    public String toString() {
        return "{point:" + this.point + ", index:" + this.index + "}";
    }
}

public class Q44 {
    // 노드의 개수
    static int n;
    static ArrayList<Position> x = new ArrayList<Position>();
    static ArrayList<Position> y = new ArrayList<Position>();
    static ArrayList<Position> z = new ArrayList<Position>();

    // 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
    static ArrayList<Edge> edges = new ArrayList<>();
    static int result = 0;

    static void solution() {
        int[] parent = new int[n + 1];
        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        // 각 행성의 좌표 정렬
        Collections.sort(x);
        Collections.sort(y);
        Collections.sort(z);

        // 인접한 노드들로부터 간선 정보를 추출하여 처리
        for (int i = 0; i < n - 1; i++) {
            edges.add(new Edge(x.get(i).getIndex(), x.get(i + 1).getIndex(),
                    Math.abs(x.get(i + 1).getPoint() - x.get(i).getPoint())));
            edges.add(new Edge(y.get(i).getIndex(), y.get(i + 1).getIndex(),
                    Math.abs(y.get(i + 1).getPoint() - y.get(i).getPoint())));
            edges.add(new Edge(z.get(i).getIndex(), z.get(i + 1).getIndex(),
                    Math.abs(z.get(i + 1).getPoint() - z.get(i).getPoint())));
        }

        // 간선을 비용순으로 정렬
        Collections.sort(edges);

        // 간선을 하나씩 확인하며
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                result += cost;
            }
        }
        System.out.println(result);
    }

    static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 모든 노드에 대한 좌표 값 입력받기
        for (int i = 1; i < n + 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            x.add(new Position(a, i));
            y.add(new Position(b, i));
            z.add(new Position(c, i));
        }
        sc.close();
        solution();
    }
}