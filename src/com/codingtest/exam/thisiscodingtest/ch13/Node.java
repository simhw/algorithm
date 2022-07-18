package com.codingtest.exam.thisiscodingtest.ch13;

public class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{x=" + x + ", y=" + y + '}';
    }
}
