package com.algorithm.exam.datastructure.linkedList;

public class LinkedList<T>{

//    T data;   // 데이터 값
//    Node<T> next; // 포인터

    private Node<T> head = null;
    private Node<T> node;

    public void addNode(T data) {
        if (head == null) {
            head = new Node<T>(data);
        }
        else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
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

        myLinkedList.printAll();
    }

}
