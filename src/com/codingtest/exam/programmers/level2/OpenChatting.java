package com.codingtest.exam.programmers.level2;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * OpenChatting
 */
public class OpenChatting {

    static class User {
        String id;
        String nickName;

        User(String id, String nickName) {
            this.id = id;
            this.nickName = nickName;
        }
    }

    public String[] solution(String[] record) {
        String[] answer = {};

        // 0. 사람 정보 초기화
        ArrayList<User> users = new ArrayList<>();

        String[] str = new String[3];
        for (int i = 0; i < record.length; i++) {

            str = record[i].split(" ");
            String action = str[0];
            switch (action) {
                case "Enter": {
                    users.add(new User(str[1], str[2]));
                    System.out.println(str[2] + "님이 들어왔습니다.");
                    break;
                }
                   
                case "Change": {
                    break;
                }
                   
                case "Leave": {
                    break;   
                }
                default:
                    break;
            }
        }
        System.out.println(users.toString());

        return answer;
    }

    public static void main(String[] args) {
        OpenChatting openChatting = new OpenChatting();
        openChatting.solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
                "Enter uid1234 Prodo", "Change uid4567 Ryan" });
    }
}