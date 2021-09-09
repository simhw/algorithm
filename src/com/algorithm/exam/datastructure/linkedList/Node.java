package com.algorithm.exam.datastructure.linkedList;
// 미리 데이터 공간을 할당하지 않아도 된다.
// 그러나 연결을 위한 별도의 데이터 공간(다음 노드의 주소 공간)이 필요하다.

public class Node<T>{

    // 데이터
    T data;
    // 포인터
    Node<T> next;

    public Node(T data){
        this.data = data;
    }
}
