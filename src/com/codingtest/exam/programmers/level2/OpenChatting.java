package com.codingtest.exam.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChatting {
    public String[] solution(String[] record) {
        HashMap<String, String > members = new HashMap<>();
        ArrayList<String> output = new ArrayList<>();
                
        String[] splited = new String[3];

        // 0. 사람 정보 초기화
        for (int i = 0; i < record.length; i++) {
            splited = record[i].split(" ");
            if (splited[0].equals("Enter")) {
                members.put(splited[1], splited[2]);
            } else if (splited[0].equals("Change")) {
                members.put(splited[1], splited[2]);
            } else {
                // members.remove(splited[1]);
            }
        }        
        // 1. 출력
        for (int i = 0; i < record.length; i++) {
            splited = record[i].split(" ");
            if (splited[0].equals("Enter")) {
                output.add(members.get(splited[1]) + "님이 들어왔습니다.");
            } else if (splited[0].equals("Leave")) {
                output.add(members.get(splited[1]) + "님이 나갔습니다.");
            }
        }

        System.out.println(output.toString());
        System.out.println(members.toString());

        String[] answer = new String[output.size()];
        return output.toArray(answer);
    }

    public static void main(String[] args) {
        OpenChatting openChatting = new OpenChatting();
        openChatting.solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
                "Enter uid1234 Prodo", "Change uid4567 Ryan" });
    }
}
