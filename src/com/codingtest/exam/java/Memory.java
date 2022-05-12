package com.codingtest.exam.java;

/**
컴파일된 파일이 실행되면 메모리 영역을 크게 Static, Stack, Heap 영역으로 구분해서 사용한다. 

(1) Static
프로그램 실행 코드, static 변수, 상수가 이 영역에 저장된다. ex) main()
이 영역에 저장된 내용은 프로그램 시작 전 로드되고 프로그램 종료 시 소멸된다. 

(2) Stack
메서드가 호출되면 지역 변수가 이 영역에 생성되었다 사라진다. 

(3) Heap
인스턴스, 배열 등 참조 변수들이 new 연산자에 의해 이 영역에 동적으로 생성된다. 
**/
class Person {
    String name;
    int age;
    String job;
}

public class Memory {
    static int result;

    public static void calculate(int a, int b) {
        result = a + b;
    }
    public static void main(String[] args) {   
        int a = 10;
        int b = 20;
        calculate(a, b);
        System.out.println("resulst = " + result);

        Person person1 = new Person();
        Person person2 = new Person();

        person1.name = "현우";
        person2.name = "폴";

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person1.name);
        System.out.println(person2.name);

    }
}