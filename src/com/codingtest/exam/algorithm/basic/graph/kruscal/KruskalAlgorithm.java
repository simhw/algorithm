package com.codingtest.exam.algorithm.basic.graph.kruscal;

import java.util.*;

public class KruskalAlgorithm {

    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();

    public void union(String nodeV, String nodeU) {
        System.out.print("parent: " + parent);
        System.out.println(", rank: " + rank);

        String root1 = find(nodeV);
        String root2 = find(nodeU);

        // union-by-rank 기법
        // 각 트리에 대해 높이를 기억해 두고,
        // union 시 두 트리의 높이가 다르면 높이가 낮은 트리를 높은 트리에 붙인다.
        if (this.rank.get(root1) > this.rank.get(root2)) {
            this.parent.put(root2, root1);
        }
        else {
            this.parent.put(root1, root2);
            if (this.rank.get(root1) == this.rank.get(root2)) {
                this.rank.put(root2, this.rank.get(root2) + 1);
            }
        }
    }

    public String find(String node) {
        // path compression 기법
        // find 를 실행한 노드에서 거쳐간 노드를 루트에 직접 연결하는 기법이다.
        // find 를 실행한 노드는 이후부터 루트 노드를 한번에 알 수 있다.
        if (this.parent.get(node) != node) {
            this.parent.put(node, this.find(this.parent.get(node)));
        }
        return this.parent.get(node);
    }

    public void makeSet(String node) {
        this.parent.put(node, node);
        this.rank.put(node, 0);
    }

    public void kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<>();
        Edge currentEdge;

        // 1. 초기화
        // 각 노드의 부모노드를 초기화한다.
        for (int i = 0; i < vertices.size(); i++) {
            makeSet(vertices.get(i));
        }
        // 2. 간선들의 거리를 기준으로 정렬해준다.(오름차순)
        Collections.sort(edges);

        for (int i = 0; i < edges.size(); i++) {
            currentEdge = edges.get(i);
            if (this.find(currentEdge.nodeV) != this.find(currentEdge.nodeU)) {
                this.union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }
        System.out.println(mst);
    }

    public static void main(String[] args) {
        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();
        ArrayList<String> vertices = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge>  edges = new ArrayList<>();
        edges.add(new Edge("A", "B", 7));
        edges.add(new Edge("A", "D", 5));
        edges.add(new Edge("B", "A", 7));
        edges.add(new Edge("B", "C", 8));
        edges.add(new Edge("B", "D", 9));
        edges.add(new Edge("B", "E", 7));
        edges.add(new Edge("C", "B", 8));
        edges.add(new Edge("C", "E", 5));
        edges.add(new Edge("D", "A", 5));
        edges.add(new Edge("D", "B", 9));
        edges.add(new Edge("D", "E", 7));
        edges.add(new Edge("D", "F", 6));
        edges.add(new Edge("E", "B", 7));
        edges.add(new Edge("E", "C", 5));
        edges.add(new Edge("E", "D", 7));
        edges.add(new Edge("E", "G", 9));
        edges.add(new Edge("F", "D", 6));
        edges.add(new Edge("F", "E", 8));
        edges.add(new Edge("F", "G", 11));
        edges.add(new Edge("G", "E", 9));
        edges.add(new Edge("G", "F", 11));

        System.out.println(vertices);
        System.out.println(edges);

        kruskalAlgorithm.kruskalFunc(vertices, edges);
    }
}
