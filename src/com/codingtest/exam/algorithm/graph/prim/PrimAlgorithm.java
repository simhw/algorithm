package com.codingtest.exam.algorithm.graph.prim;

import com.codingtest.exam.datastructure.doublelinkedlist.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

// 최소신장트리의 일종인 알고리즘이다.
public class PrimAlgorithm {
    public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<>();
        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<>();
        ArrayList<String> connectedNodes = new ArrayList<>();
        ArrayList<Edge> candidateEdges = new ArrayList<>();

        // 0. 초기화
        // 모든 간선 정보를 저장한다.(adjacentEdges)
        Edge currEdge;
        for (int i = 0; i < edges.size(); i++) {
            currEdge = edges.get(i);
            if (!adjacentEdges.containsKey(currEdge.nodeV)) {
                adjacentEdges.put(currEdge.nodeV, new ArrayList<Edge>());
            }
            if (!adjacentEdges.containsKey(currEdge.nodeO)) {
                adjacentEdges.put(currEdge.nodeO, new ArrayList<Edge>());
            }
        }
        ArrayList<Edge> currEdgeList;
        for (int i = 0; i < edges.size(); i++) {
            currEdge = edges.get(i);
            currEdgeList = adjacentEdges.get(currEdge.nodeV);
            currEdgeList.add(new Edge(currEdge.nodeV, currEdge.nodeO, currEdge.weight));
            currEdgeList = adjacentEdges.get(currEdge.nodeO);
            currEdgeList.add(new Edge(currEdge.nodeO, currEdge.nodeV, currEdge.weight));
        }
        System.out.println(adjacentEdges);
        // 1. 임의의 시작 정점을 선택, 연결된 노드 집합(connectedNodes)에 삽입한다.
        connectedNodes.add(startNode);
        // 2. 선택된 정점에 연결된 간선들을 간선 리스트(candidateEdges)에 삽입한다.
        candidateEdges = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < candidateEdges.size(); i++) {
            priorityQueue.add(candidateEdges.get(i));
        }

        while (!priorityQueue.isEmpty()) {
            // 3. 간선 리스트(candidateEdges)에 연결된 간선들에서 최소 가중치를 가지는 간선부터 추출해서,
            Edge nextNode = priorityQueue.poll();

            // 해당 간선에 연결된 인접 정점이 '연결된 노드 집합'에 이미 들어있으면 스킵하고(이미 방문한 노드, cycle 발생),
            // 해당 간선에 연결된 인접 정점의 간선들 중 '연결된 노드 집합'에 없는 노드와 연결된 간선들만 간선 리스트에 삽입한다.
            System.out.println("candidateEdges: " + candidateEdges);
            if (!connectedNodes.contains(nextNode.nodeO)) {
                connectedNodes.add(nextNode.nodeO);
                mst.add(nextNode);
                candidateEdges = adjacentEdges.getOrDefault(nextNode.nodeO, new ArrayList<Edge>());
                for (int i = 0; i < candidateEdges.size(); i++) {
                    if (!connectedNodes.contains(candidateEdges.get(i).nodeO)) {
                        priorityQueue.add(candidateEdges.get(i));
                    }
                }
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        PrimAlgorithm primAlgorithm = new PrimAlgorithm();
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge("A", "B", 7));
        edges.add(new Edge("A", "D", 5));
        edges.add(new Edge("B", "C", 8));
        edges.add(new Edge("B", "D", 9));
        edges.add(new Edge("B", "E", 7));
        edges.add(new Edge("C", "E", 5));
        edges.add(new Edge("D", "E", 7));
        edges.add(new Edge("D", "F", 6));
        edges.add(new Edge("E", "F", 8));
        edges.add(new Edge("E", "G", 9));
        edges.add(new Edge("F", "G", 11));

        ArrayList<Edge> mst = primAlgorithm.primFunc("A", edges);
        System.out.println(mst);

    }
}
