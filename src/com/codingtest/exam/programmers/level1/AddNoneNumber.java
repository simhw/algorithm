package com.codingtest.exam.programmers.level1;

public class AddNoneNumber {
    public int solution(int[] numbers) {
        int answer = -1;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        answer = 45 - sum;
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        AddNoneNumber addNoneNumber = new AddNoneNumber();
        int[] numbers = {1,2,3,4,6,7,8,0};
        addNoneNumber.solution(numbers);
    }
}
