package com.codingtest.exam.thisiscodingtest.ch09;

public class Node implements Comparable<Node>{
    int vertex;
    int edge;
    
    Node (int vertex, int edge) {
        this.vertex = vertex;
        this.edge = edge;
    }

    public String toString() {
        return "{vertex:" + this.vertex + ", edge:" + this.edge + "}";
    }

    @Override
    public int compareTo(Node o) {
        return this.edge - o.edge;
    }
}
