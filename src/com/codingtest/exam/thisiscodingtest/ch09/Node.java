package com.codingtest.exam.thisiscodingtest.ch09;

public class Node {
    int vertex; // 정점
    int edge;   // 간선

    Node(int vertex, int edge) {
        this.vertex = vertex;
        this.edge = edge;
    }

    @Override
    public String toString() {
        return "{vertex=" + vertex + ", edge=" + edge + '}';
    }
}