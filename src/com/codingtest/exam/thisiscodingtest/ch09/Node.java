package com.codingtest.exam.thisiscodingtest.ch09;

<<<<<<< HEAD
public class Node {
    int vertex; // 정점
    int edge;   // 간선

    Node(int vertex, int edge) {
=======
public class Node implements Comparable<Node>{
    int vertex;
    int edge;
    
    Node (int vertex, int edge) {
>>>>>>> origin/master
        this.vertex = vertex;
        this.edge = edge;
    }

<<<<<<< HEAD
    @Override
    public String toString() {
        return "{vertex=" + vertex + ", edge=" + edge + '}';
    }
}
=======
    public String toString() {
        return "{vertex:" + this.vertex + ", edge:" + this.edge + "}";
    }

    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        return this.edge - o.edge;
    }
}
>>>>>>> origin/master
