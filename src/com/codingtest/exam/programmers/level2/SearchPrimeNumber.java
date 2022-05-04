package com.codingtest.exam.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPrimeNumber {
    public int solution(int n, int k) {
        int answer = -1;
        List<Integer> num = new ArrayList<>();
        int q = n;  // 몫
        int r = 0;  // 나머지 

        //1. k 진수로 변환 
        while(q > 0) {            
            System.out.println(Math.ceil(q % k));
            r = (int)Math.ceil(q % k);
            q /= k;
            // System.out.println("q = " + q + " r = " + r);
            num.add(r);
        }

        System.out.println(num.toString());
        return answer;
    }

    public boolean isPrimeNumber(int x) {
        int end = (int) Math.sqrt(x);
        System.out.println("end = " + end);
        for (int i = 2; i <= end; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
 
    // 에라토스테네스 체 
    // 대량의 소수를 한번에 판별하고자 할 때 사용한다. 
    public void primNumberSieve(int number) {
        int[] a = new int[number + 1];

        // 1. 소수를 판별할 범위만큼 배열을 할당하고 값을 초기화한다. 
        for (int i = 2; i <= number; i++) {
            a[i] = i;
        }

        // 2. 2부터 시작해서 특정 숫자의 배수에 해당하는 숫자들을 모두 지운다.
        for (int i = 2; i <= number; i++) {
            // 3. 이미 지워진 숫자의 경우 건너뛴다.  
            if (a[i] == 0) continue;
            for (int j = i + i; j <= number; j += i) {
                a[j] = 0;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        SearchPrimeNumber searchPrimeNumber = new SearchPrimeNumber();
        searchPrimeNumber.solution(145891, 3);
    }
}
