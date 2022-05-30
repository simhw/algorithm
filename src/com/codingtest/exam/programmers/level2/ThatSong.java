package com.codingtest.exam.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;

public class ThatSong {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int max = 0;
        // 1. # 음계 치환
        HashMap<String, String> scales = new HashMap<>();
        scales.put("C#", "c");
        scales.put("D#", "d");
        scales.put("F#", "f");
        scales.put("G#", "g");
        scales.put("A#", "a");

        for (String scale : scales.keySet()) {
            m = m.replace(scale, scales.get(scale));
        }

        // 2. 문자열 비교
        // 재생 시작, 재생 끝, 노래 제목, 악보
        String[] arr = new String[4];
        int time = 0;

        for (int i = 0; i < musicinfos.length; i++) {
            // 2-1. 재생 시간 계산
            arr = musicinfos[i].split(",");
            int start = Integer.parseInt(arr[0].split(":")[0]) * 60;
            start += Integer.parseInt(arr[0].split(":")[1]);

            int end = Integer.parseInt(arr[1].split(":")[0]) * 60;
            end += Integer.parseInt(arr[1].split(":")[1]);

            time = end - start;
            // 2-2. 재생된 악보 계산
            // 음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이 처음부터 반복해서 재생된다.
            // 음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다.

            String play = "";
            for (String scale : scales.keySet()) {
                arr[3] = arr[3].replace(scale, scales.get(scale));
            }

            if (time > arr[3].length()) {
                int repeat = time / arr[3].length();
                for (int j = 0; j < repeat; j++) {
                    play += arr[3];
                }
            } else {
                play = arr[3].substring(0, time + 1);
            }

            System.out.println("time = " + time);
            System.out.println("play = " + play);

            // 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
            if (play.contains(m)) {
                if (max < time) {
                    answer = arr[2];
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        ThatSong thatSong = new ThatSong();
        thatSong.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"});
    }
}
