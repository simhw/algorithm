package com.codingtest.exam.thisiscodingtest.ch14;

import java.util.*;

// 카드 정렬하기
public class Q26 {
    static int n;
    static PriorityQueue<Integer> heap = new PriorityQueue<>();

    static void solution() {
        int answer = 0;
        while (heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();
            // 카드 묶음을 합쳐서 다시 삽입
            int sum = a + b;
            heap.add(sum);
            answer += sum;
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            heap.add(sc.nextInt());
        }        
        sc.close();
        solution();
    }
}
