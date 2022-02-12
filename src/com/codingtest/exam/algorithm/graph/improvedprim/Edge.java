package com.codingtest.exam.algorithm.graph.improvedprim;

public class Edge implements Comparable<Edge>{
    public String node;
    public Integer weight;

    public Edge(String node, Integer weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" + node + ", " + weight + "}";
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}
