package com.codingtest.exam.thisiscodingtest.ch06;

// 예제 6-11 성적이 낮는 순서로 학생 출력하기

import java.util.*;

public class Ex06 {

    static int N;
    static List<Student> students;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Student(name, score));
        }
        sc.close();
        
        Collections.sort(students);
        System.out.println(students);
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // 정렬 기준은 '점수가 낮은 순서'
    @Override
    public int compareTo(Student other) {
        if (this.score < other.score) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "{name = " + name + " , score = " + score + "}";
    }
}
