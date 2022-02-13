package com.codingtest.exam.algorithm.basic.graph.prim;


public class Edge implements Comparable<Edge> {
    String nodeV;
    String nodeO;
    Integer weight;

    public Edge(String nodeV, String nodeO, Integer weight) {
        this.nodeV = nodeV;
        this.nodeO = nodeO;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + nodeV + ", " + nodeO + ": " + weight + ")";
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}
