package com.algorithm.exam.datastructure.doublelinkedlist;

public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    // 맨 뒤에 데이터를 삽입할 경우
    public void addNode(T data){
        if (this.head == null){
            this.head = new Node<T>(data);
            this.tail = this.head;
        }
        else {
            Node<T> node = this.head;
            while (node.next != null){
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    // 임의 노드 앞에 노드를 추가하는 경우
    public boolean addNodeInside(T existedData, T data){

        // 노드가 없는 경우
        if (this.head == null){
            this.head = new Node<T>(data);
            this.tail = head;
            return true;
        }

        // 삽입하려는 노드 뒤가 맨 앞인 경우
        else if (existedData == this.head.data){
            Node<T> newHead = new Node<>(data);
            newHead.next = this.head;
            this.head.prev = newHead;
            this.head = newHead;
            return true;
        }

        // 나머지 경우
        else {
            Node<T> node = this.head;
            while (node != null){
                if (existedData == node.data){
                    Node<T> prevNode = node.prev;

                    node.prev = new Node<>(data);
                    prevNode.next = node.prev;

                    node.prev.prev = prevNode;
                    node.prev.next = node;

                    return true;
                }
                else {
                    node = node.next;
                }
            }
            return false;
        }
    }

    public Node<T> searchFromHead(T isData){
        if (this.head == null){
            return null;
        }
        else {
            Node<T> node = this.head;
            while (node != null){
                if (node.data == isData){
                    return node;
                }
                else {
                    node = node.next;
                }
            }
            return null;
        }
    }
    public Node<T> searchFromTail(Node<T> isData){
        if (this.tail == null){
            return null;
        }
        else {
            Node<T> node = this.tail;
            while (node != null){
                if (node.data == isData){
                    return node;
                }
                else {
                    node = node.prev;
                }
            }
            return null;
        }
    }

    public void printAll(){
        if (head != null){
            Node<T> node = this.head;
            System.out.println(node.data);

            while (node.next != null){
                System.out.println(node.next.data);
                node = node.next;
            }
        }
    }


    public static void main(String args[]){
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        for (int i = 1; i < 5; i++){
            doubleLinkedList.addNode(i);
        }

        doubleLinkedList.printAll();
        System.out.println("----------------");

        doubleLinkedList.addNodeInside(3, 2);

        doubleLinkedList.printAll();
        System.out.println("----------------");

        doubleLinkedList.addNodeInside(5, 10);
        doubleLinkedList.addNodeInside(1, 0);

        doubleLinkedList.printAll();
        System.out.println("----------------");


        doubleLinkedList.addNode(10);

        doubleLinkedList.printAll();
        System.out.println("----------------");


    }
}
