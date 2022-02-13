package com.codingtest.exam.algorithm.basic.graph.dijkstra;


public class Edge implements Comparable<Edge> {
    String vertex;
    Integer distance;

    public Edge(String vertex,Integer distance){
        this.vertex=vertex;
        this.distance=distance;
    }
    public String toString(){
        return"vertex: "+this.vertex+" distance: "+this.distance;
    }

    @Override
    public int compareTo(Edge edge){
        return this.distance-edge.distance;
    }
}
