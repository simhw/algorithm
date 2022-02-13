package com.codingtest.exam.algorithm.basic.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BreadthFirstSearch {
    public static ArrayList<String> bfsFunc1(HashMap<String, ArrayList<String>> graph, String root) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        // 시작 노드는 직접 입력해주어야 한다.
        visited.add(root);
        needVisit.addAll(graph.get(root));

        while (!needVisit.isEmpty()) {
            System.out.println("visited: " + visited);
            System.out.println("needVisit: " + needVisit);
            System.out.println("=================================================================");

            String key = needVisit.remove(0);
            visited.add(key);

            for (int i = 0; i < graph.get(key).size(); i++) {
                String child = graph.get(key).get(i);
                if (visited.contains(child)) continue;
                needVisit.add(child);
            }
        }
        return visited;
    }
    public static ArrayList<String> bfsFunc2(HashMap<String, ArrayList<String>> graph, String root) {
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

            String node = needVisit.remove(0);
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
        System.out.println(bfsFunc2(graph, "A"));
    }
}
