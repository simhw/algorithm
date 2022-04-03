package com.codingtest.exam.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * OpenChatting
 */


public class OpenChatting {
    public String[] solution(String[] record) {
        HashMap<String, String > members = new HashMap<>();
        ArrayList<String> output = new ArrayList<>();
        String[] str = new String[3];
        // 0. 사람 정보 초기화
        for (int i = 0; i < record.length; i++) {
            str = record[i].split(" ");
            String event = str[0];
            switch (event) {
                case "Enter":
                case "Change":
                    members.put(str[1], str[2]);
                    break;
                case "Leave":
                    members.remove(str[1]);
                    break;
                default:
                    break;
            }
        }
        // 1. 출력
        String nickName;
        for (int i = 0; i < record.length; i++) {
            str = record[i].split(" ");
            nickName = members.get(str[1]);
            if (str[0].equals("Enter")) {
                output.add(nickName + "님이 들어왔습니다.");
            } else if (str[0].equals("Leave")) {
                output.add(nickName + "님이 나갔습니다.");
            } else continue;
        }

        String[] answer = new String[output.size()];
        return output.toArray(answer);
    }

    public static void main(String[] args) {
        OpenChatting openChatting = new OpenChatting();
        openChatting.solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
                "Enter uid1234 Prodo", "Change uid4567 Ryan" });
    }
}
