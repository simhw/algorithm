package com.codingtest.exam.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PreseKeyPad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        //  키패드 
        HashMap <String, ArrayList<Integer>> hashMap = new HashMap<>();
        hashMap.put("1", new ArrayList<Integer>(Arrays.asList(0, 0)));
        hashMap.put("2", new ArrayList<Integer>(Arrays.asList(0, 1)));
        hashMap.put("3", new ArrayList<Integer>(Arrays.asList(0, 2)));
        hashMap.put("4", new ArrayList<Integer>(Arrays.asList(1, 0)));
        hashMap.put("5", new ArrayList<Integer>(Arrays.asList(1, 1)));
        hashMap.put("6", new ArrayList<Integer>(Arrays.asList(1, 2)));
        hashMap.put("7", new ArrayList<Integer>(Arrays.asList(2, 0)));
        hashMap.put("8", new ArrayList<Integer>(Arrays.asList(2, 1)));
        hashMap.put("9", new ArrayList<Integer>(Arrays.asList(2, 2)));
        hashMap.put("*", new ArrayList<Integer>(Arrays.asList(3, 0)));
        hashMap.put("0", new ArrayList<Integer>(Arrays.asList(3, 1)));
        hashMap.put("#", new ArrayList<Integer>(Arrays.asList(3, 2)));
        
        ArrayList<Integer> nPos = new ArrayList<>();
        ArrayList<Integer> rPos = new ArrayList<>();
        ArrayList<Integer> lPos = new ArrayList<>();

        String left = "*"; 
        String right = "#";

        for (int number : numbers) {
            String num = Integer.toString(number);
            // 2. 왼손 사용  
            if (num.equals("1") || num.equals("4") || num.equals("7") || num.equals("*")) {
                left = num;                
                answer += "L";
                continue;
            }
            // 3. 오른손 사용 
            else if (num.equals("3") || num.equals("6") || num.equals("9") || num.equals("#")) {
                right = num;
                answer += "R";
                continue;
            }
            // 4. 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용
            else {
                int leftDis, rightDis;

                nPos = hashMap.get(num);
                lPos = hashMap.get(left);
                rPos = hashMap.get(right);

                leftDis = Math.abs(nPos.get(0) - lPos.get(0)) + Math.abs(nPos.get(1) - lPos.get(1));
                rightDis = Math.abs(nPos.get(0) - rPos.get(0)) + Math.abs(nPos.get(1) - rPos.get(1));

                if(leftDis > rightDis) {
                    right = num;
                    answer += "R";
                } else if (leftDis < rightDis) {
                    left = num;
                    answer += "L";
                } 
                // 4.1 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용
                else if (leftDis == rightDis) {
                    if (hand.equals("right")) {
                        right = num;
                        answer += "R";
                    } else if (hand.equals("left")){
                        left = num;
                        answer += "L";
                    }
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        PreseKeyPad preseKeyPad = new PreseKeyPad();
        preseKeyPad.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");

    }
}
