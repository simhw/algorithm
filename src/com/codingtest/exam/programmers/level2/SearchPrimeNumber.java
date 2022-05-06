package com.codingtest.exam.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPrimeNumber {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuffer str = new StringBuffer();
        int r = 0;  // 나머지 

        //1. k 진수로 변환 
        while(n > 0) {            
            r = (int) n % k;
            n /= k;
            str.append(r + "");
        }
        str.reverse();
        System.out.println(str);

        // 2. 소수 개수
        String num = "";
        List<String> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0'){
                list.add(num.toString());
                num = "";
            } else{
                num += str.charAt(i);
            }

            if (i == str.length() - 1) {
                list.add(num.toString());
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).length() > 0) {
                if(isPrimeNumber(Long.parseLong(list.get(i)))) {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public boolean isPrimeNumber(Long x) {
        if (x == 1) return false;
        int end = (int) Math.sqrt(x);
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
        searchPrimeNumber.solution(437674, 3);
    }
}
