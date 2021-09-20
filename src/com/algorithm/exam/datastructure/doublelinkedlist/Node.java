package com.algorithm.exam.datastructure.doublelinkedlist;

public class Node<T> {
    // 더블 링크드 리스트
    // 양방향으로 연결되어 있어서 노드 탐색이 양쪽으로 모두 가능하다.
    // 데이터
    T data;
    // 포인터
    Node<T> prev = null;
    Node<T> next = null;

    public Node(T data){
        this.data = data;
    }
}
