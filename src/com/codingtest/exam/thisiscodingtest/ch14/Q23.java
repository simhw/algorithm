package com.codingtest.exam.thisiscodingtest.ch14;

import java.util.*;

// 국영수
class Student implements Comparable<Student> {
    String name;
    int kor;
    int eng;
    int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    /*
    [ 정렬 기준 ]
    1) 두 번째 원소를 기준으로 내림차순 정렬
    2) 두 번째 원소가 같은 경우, 세 번째 원소를 기준으로 오름차순 정렬
    3) 세 번째 원소가 같은 경우, 네 번째 원소를 기준으로 내림차순 정렬
    4) 네 번째 원소가 같은 경우, 첫 번째 원소를 기준으로 오름차순 정렬
    */
    @Override
    public int compareTo(Student o) {
        return this.kor > o.kor ? -1 : this.kor < o.kor ? 1 : this.eng > o.eng ? 1 : this.eng < o.eng ? -1 : this.math > o.math ? -1 : this.math < o.math ? 1 : this.name.compareTo(o.name);
    }
}

public class Q23 {
    static int n;
    static List<Student> students;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int math = sc.nextInt();
            students.add(new Student(name, kor, eng, math));
        }

        Collections.sort(students);
        for (int i = 0; i < n; i++) {
            System.out.println(students.get(i).name);
        }
    }
}
