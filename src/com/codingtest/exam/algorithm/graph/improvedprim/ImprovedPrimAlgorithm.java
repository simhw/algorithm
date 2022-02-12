package com.codingtest.exam.algorithm.graph.improvedprim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
public class ImprovedPrimAlgorithm {
    public ArrayList<Path> primImproveFunc(HashMap<String, HashMap<String, Integer>> graph, String startNode) {
        // 최소 신장 트리 (Minimum Spanning Tree)
        // 개선된 프림 알고리즘
        // 간선이 아닌 노드를 중심으로 우선순위 큐를 적용하는 방식이다.
        ArrayList<Path> mst = new ArrayList<>();
        Integer totalWeight = 0;

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        HashMap<String, Edge> keyObjects = new HashMap<>();
        HashMap<String, String> mstPath = new HashMap<>();

        Edge edgeObj, poppedEdge, linkedEdge;
        HashMap<String, Integer> linkedEdges;

        // 0. 초기화
        // 특정 정점의 key 값은 0, 이외 정점들의 key 값은 INF 로 놓고,
        // 모든 정점의 key 값은 우선순위 큐에 넣는다.
        for (String key: graph.keySet()) {
            if (key == startNode) {
                edgeObj = new Edge(key,0);
                mstPath.put(key, key);
            }
            else {
                edgeObj = new Edge(key, 9999);
                mstPath.put(key, null);
            }
            priorityQueue.add(edgeObj);
            keyObjects.put(key, edgeObj);
        }

        // 개선된 프림 알고리즘
        while (!keyObjects.isEmpty()) {
            System.out.println("keyObjects: " + keyObjects);
            // extract min
            // decrease key
            // 이미 방문한 노드를 삭제해 cycle 을 확인한다.
            poppedEdge = priorityQueue.poll();
            keyObjects.remove(poppedEdge.node);

            mst.add(new Path(mstPath.get(poppedEdge.node), poppedEdge.node, poppedEdge.weight));
            totalWeight += poppedEdge.weight;

            linkedEdges = graph.get(poppedEdge.node);
            for (String adjacent: linkedEdges.keySet()) {
                if (keyObjects.containsKey(adjacent)) {
                    linkedEdge = keyObjects.get(adjacent);

                    if (linkedEdge.weight > linkedEdges.get(adjacent)) {
                        linkedEdge.weight = linkedEdges.get(adjacent);
                        mstPath.put(adjacent, poppedEdge.node);

                        priorityQueue.remove(linkedEdge);
                        priorityQueue.add(linkedEdge);
                    }
                }
            }
        }
        System.out.println("mstPath: " + mstPath);
        System.out.println("totalWeight: " + totalWeight);
        return mst;
    }
    public static void main(String[] args) {
        ImprovedPrimAlgorithm primImprovedAlgorithm = new ImprovedPrimAlgorithm();
        HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
        HashMap<String, Integer> edges = new HashMap<>();
        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("D", 5);
        graph.put("A", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 7);
        edges.put("D", 9);
        edges.put("C", 8);
        edges.put("E", 7);
        graph.put("B", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 8);
        edges.put("E", 5);
        graph.put("C", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 5);
        edges.put("B", 9);
        edges.put("E", 7);
        edges.put("F", 6);
        graph.put("D", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("C", 5);
        edges.put("D", 7);
        edges.put("F", 8);
        edges.put("G", 9);
        graph.put("E", edges);

        edges = new HashMap<String, Integer>();
        edges.put("D", 6);
        edges.put("E", 8);
        edges.put("G", 11);
        graph.put("F", edges);

        edges = new HashMap<String, Integer>();
        edges.put("E", 9);
        edges.put("F", 11);
        graph.put("G", edges);

        System.out.println(graph + "\n");
        ArrayList<Path> mst = primImprovedAlgorithm.primImproveFunc(graph, "A");
        System.out.println(mst);
    }
}
