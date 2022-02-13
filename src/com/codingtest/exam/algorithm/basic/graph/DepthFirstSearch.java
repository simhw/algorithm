package com.codingtest.exam.algorithm.basic.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DepthFirstSearch {
    public static ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>> graph, String root) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        // 시작 노드는 직접 입력해주어야 한다.
        needVisit.add(root);

        int cnt = 0;
        while (!needVisit.isEmpty()) {
            cnt++;
            System.out.println("visited: " + visited);
            System.out.println("needVisit: " + needVisit);
            System.out.println("=================================================================");

            // BFS 와 유일하게 다른 점이다.
            // BFS: 스택
            // DFS: 큐
            String node = needVisit.remove(needVisit.size() - 1);
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        System.out.println("시간 복잡도: " + cnt);
        return visited;
    }


    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        System.out.println(graph);
        System.out.println(dfsFunc(graph, "A"));
    }
}
