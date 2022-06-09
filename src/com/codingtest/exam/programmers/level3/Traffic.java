package com.codingtest.exam.programmers.level3;

public class Traffic {
    public int solution(String[] lines) {
        int answer = 0;
        double[][] logs = new double[lines.length][2];

        for (int i = 0; i < lines.length; i++) {
            String[] splited = lines[i].split(" ");
            String[] s = splited[1].split(":"); // 응답완료시간 
            Double t = Double.parseDouble(splited[2].split("s")[0]); // 처리시간  (시작시간과 끝시간을 포함)
            Double end = (3600.0 * Integer.parseInt(s[0])) + (60.0 * Integer.parseInt(s[1])) + Double.parseDouble(s[2]);    // 응답완료시간 
            logs[i][0] = (end - t) + 0.001;    // 시작시간 
            logs[i][1] = end;
        }

        for (int i = 0; i < logs.length; i++) {
            for (int j = 0; j < logs[i].length; j++) {
                // 0 ~ 0.999(1초) 구간 설정 
                double left = logs[i][j];
                double right = (Math.round((left + 0.999) * 1000) / 1000.0);   
                int count = 0;
                for (int k = 0; k < logs.length; k++) {
                    if ((logs[k][0] >= left && logs[k][0] <= right) // 해당 범위에 로그의 시작점이 위치해 있는 경우
                            || (logs[k][1] >= left && logs[k][1] <= right)// 해당 범위에 로그의 끝점이 위치해 있는 경우
                            || (logs[k][0] <= left && logs[k][1] >= right)) { // 로그의 시작 시간과 끝나는 시간이 해당 범위보다 넓은 경우

                        count += 1;
                    }
                }
                answer = Math.max(answer, count);
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        Traffic traffic = new Traffic();
        traffic.solution(new String[] {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"});
    }
}