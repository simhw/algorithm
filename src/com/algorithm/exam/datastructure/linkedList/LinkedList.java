package com.algorithm.exam.datastructure.linkedList;

public class LinkedList<T>{

//    T data;   // 데이터 값
//    Node<T> next; // 포인터

    private Node<T> head = null;
    private Node<T> node;

    private Node<T> searchNode(T data) {
        if(this.head == null) {
            return null;
        }
        else{
            Node<T> node = this.head;
            while(node != null){
                if(node.data == data)
                    return node;
                else
                    node = node.next;
            }
            return null;
        }
    }

    // 맨 뒤에 데이터를 삽입할 경우
    public void addNode(T data) {
        if (head == null) {
            head = new Node<T>(data);
        }
        else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            Node<T> nextNode = new Node<>(data);
            node.next = nextNode;
        }
    }

    // 특정 노드 뒤에 데이터를 삽입할 경우
    public void addNodeInside(T data, T isData){
        // 삽입하려는 노드의 이전 노드
        Node<T> previousNode = this.searchNode(isData);

        if(previousNode == null){
            addNode(data);
        }
        else{
            // 삽입하려는 노드의 다음 노드
            Node<T> nextNode = previousNode.next;

//            Node<T> node = new Node<T>(data);
//            previousNode.next = node;

            previousNode.next = new Node<>(data);
            previousNode.next.next = nextNode;
        }
    }

    // 특정 노드를 삭제할 경우
    public boolean deleteNode(T data){
        if(this.head == null){
            return false;
        }
        else{
            Node<T> node = this.head;
            // 삭제할 데이터가 맨 처음 노드일 경우
            if(node.data == data){
                this.head = this.node.next;
                return true;
            }
            else{
                // 삭제할 데이터가 중간 노드일 경우
                // 삭제할 데이터가 맨 마지막 노드일 경우
                while(node.next != null) {
                    if (node.next.data == data) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }

    public void printAll() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.print(node.data + " ");
            System.out.println(node.next);

            while (node.next != null) {
                node = node.next;
                System.out.print(node.data + " ");
                System.out.println(node.next);
            }
        }
    }

    public static void main(String args[]){
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        myLinkedList.addNode(1);
        myLinkedList.addNode(2);
        myLinkedList.addNode(3);
        myLinkedList.addNodeInside(5, 1);
        myLinkedList.deleteNode(2);
        myLinkedList.addNodeInside(6, 100);

        myLinkedList.printAll();
    }

}
