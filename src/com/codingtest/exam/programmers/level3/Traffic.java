package com.codingtest.exam.programmers.level3;

import java.util.Arrays;

public class Traffic {
    // 초당 최대 처리량은 요청의 응답 완료 여부에 관계없이 임의 시간부터 1초(=1,000밀리초)간 처리하는 요청의 최대 개수를 의미한다.

    public int solution(String[] lines) {
        int answer = 0;
        double[][] logs = new double[lines.length][2];

        for (int i = 0; i < lines.length; i++) {
            String[] splited = lines[i].split(" ");
            String[] s = splited[1].split(":");
            Double time = Double.parseDouble(splited[2].split("s")[0]);
            Double end = (3600.0 * Integer.parseInt(s[0])) + (60.0 * Integer.parseInt(s[1])) + Double.parseDouble(s[2]);
            Double start = end - time;
            logs[i][0] = start + 0.001;
            logs[i][1] = end;
        }

        for (int i = 0; i < logs.length; i++) {
            double term1 = logs[i][0];
            double term2 = logs[i][1];
            int count = 0;
            System.out.println(Arrays.toString(logs[i]));
            // 0 ~ 0.999초
            for (int j = 0; j < logs.length; j++) {
                if ((logs[j][0] >= term1 && logs[j][0] <= term1 + 1)
                        || (logs[j][1] >= term1 && logs[j][1] <= term1 + 1)
                        || (logs[j][0] >= term2 && logs[j][0] <= term2 + 1)
                        || (logs[j][1] >= term2 && logs[j][1] <= term2 + 1)) {
                    count += 1;
                }
            }
            answer = Math.max(answer, count);

        }
        System.out.println("answer = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        Traffic traffic = new Traffic();
        traffic.solution(new String[] {"2016-09-15 03:10:33.020 0.011s", "2016-09-15 01:00:07.000 2s"});
    }
}