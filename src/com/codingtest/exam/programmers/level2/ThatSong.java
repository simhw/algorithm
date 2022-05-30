package com.codingtest.exam.programmers.level2;

import java.util.HashMap;

public class ThatSong {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;
        // 1. # 음계 치환
        HashMap<String, String> scales = new HashMap<>();
        scales.put("C#", "c");
        scales.put("D#", "d");
        scales.put("F#", "f");
        scales.put("G#", "g");
        scales.put("A#", "a");

        for (String scale : scales.keySet()) {
            m = m.replaceAll(scale, scales.get(scale));
        }

        // 2. 문자열 비교
        String[] arr;
        int time = 0;

        for (int i = 0; i < musicinfos.length; i++) {
            // 2-1. 재생 시간 계산
            arr = musicinfos[i].split(",");

            String start[] = arr[0].split(":");
            String end[] = arr[1].split(":");

            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);

            time = endTime - startTime;

            String play = "";
            for (String scale : scales.keySet()) {
                arr[3] = arr[3].replaceAll(scale, scales.get(scale));
            }

            // 2-2. 재생된 악보 계산
            for (int j = 0; j < time; j++) {
                play += arr[3].charAt(j % arr[3].length());
            }

            System.out.println("time = " + time);
            System.out.println("play = " + play);

            // 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
            if (play.contains(m)) {
                if (max < time) {
                    max = time;
                    answer = arr[2];
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        ThatSong thatSong = new ThatSong();
        thatSong.solution("ABC", new String[]{"00:00,00:05,HI,ABC#ABC"});
    }
}
