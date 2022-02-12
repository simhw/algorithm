package com.codingtest.exam.algorithm.graph.improvedprim;

public class Path {
    public String node1;
    public String node2;
    public Integer weight;

    public Path(String node1, String node2, Integer weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Path{" + node1 + ", " + node2 + ", " + weight + '}';
    }
}
