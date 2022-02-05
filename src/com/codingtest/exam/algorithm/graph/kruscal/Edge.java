package com.codingtest.exam.algorithm.graph.kruscal;

public class Edge implements Comparable<Edge> {
    String nodeV;
    String nodeU;
    Integer weight;

    public Edge(String nodeV, String nodeU, Integer weight) {
        this.nodeV = nodeV;
        this.nodeU = nodeU;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + nodeV + ", " +  nodeU + ": " + weight + ")";
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}
