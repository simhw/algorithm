package com.codingtest.exam.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{
    String vertex;
    Integer distance;

    public Edge(String vertex, Integer distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
    public String toString() {
        return "vertex: " + this.vertex + " distance: " + this.distance;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.distance - edge.distance;
    }
}
// 최단 경로를 구하는 알고리즘 중 하나이다.
public class DijkstraAlgorithm {
    public static HashMap<String, Integer> dijkstra(HashMap<String, ArrayList<Edge>> graph, String start) {
        // 1. 초기화
        // 시작 지점에서 각 지점까지의 거리를 리스트에 넣어준다.
        // 시작 지점 거리는 0,  나머지는 INF 으로 저장한다.
        HashMap<String, Integer> distances = new HashMap<>();
        for (String key: graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        // 우선순위 큐 (Min Heap)
        // 각 지점까지의 거리가 최소 값이라면 우선순위 큐에 지점을 삽입해준다.
        PriorityQueue<Edge> priority = new PriorityQueue<>();
        priority.add(new Edge(start, distances.get(start)));

        // 다익스트라 알고리즘 작성
        while (!priority.isEmpty()) {
            Edge parent = priority.poll();
            System.out.println(parent);

            if (parent.distance > distances.get(parent.vertex)) {
                continue;
            }
            for (int i = 0; i < graph.get(parent.vertex).size(); i++) {
                Edge child = graph.get(parent.vertex).get(i);
                if (parent.distance + child.distance < distances.get(child.vertex)) {
                    child.distance += parent.distance;
                    distances.put(child.vertex, child.distance);
                    priority.add(child);
                }
            }
            System.out.println(distances);
        }
        return distances;
    }
    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge("B", 8), new Edge("C", 1), new Edge("D", 2))));
        graph.put("B", new ArrayList<Edge>(Arrays.asList()));
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge("B", 5), new Edge("D", 2))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge("E", 3), new Edge("F", 5))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge("F", 1))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge("A", 5))));

        dijkstra(graph, "A");
    }
}
