package com.codingtest.exam.thisiscodingtest.ch05;

import java.util.ArrayList;
// 스택
public class Ex01 {
    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(5);
        stack.add(2);
        stack.add(3);
        stack.add(7);
        stack.remove(stack.size() - 1);
        stack.add(1);
        stack.add(4);
        stack.remove(stack.size() - 1);
        System.out.println(stack);
    }
}
