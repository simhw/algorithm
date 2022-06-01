package com.codingtest.exam.fastcampus.basic.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    public static void main(String[] args) {
        // 생성 및 추가
        // HashMap<key 자료형 , value 자료형> 변수명 = new HashMap<>()
        HashMap<Integer, Integer> graph1 = new HashMap<>();
        HashMap<String, Integer> graph2 = new HashMap<>();
        HashMap<String, ArrayList<Integer>> graph3 = new HashMap<>();

        graph2.put("A", 1);
        graph2.put("B", 3);
        graph2.put("C", 7);

        // 읽기
        System.out.println(graph2);
        System.out.println(graph2.get("A"));
        // 수정
        graph2.put("B", 6);
        // 삭제
        graph2.remove("A");

        System.out.println(graph2);
    }
}
