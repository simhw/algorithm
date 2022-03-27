package com.codingtest.exam.programmers.level1;

/**
 * ReportResult
 */
import java.util.*;

public class ReportResult {

    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        HashMap<String, ArrayList<String>> reported = new HashMap<>();
        HashMap<String, Integer> reportedCnt = new HashMap<>();
        String user, reportedUser;

        // 중복 신고 제거
        for (int i = 0; i < report.length; i++) {
            String[] splited = report[i].split(" ");
            hashMap.put(report[i], new ArrayList<String>(Arrays.asList(splited)));
        }
        // 신고 회원 테이블 초기화 및 신고 횟수 계산
        for (String key:hashMap.keySet()) {
            user = hashMap.get(key).get(0);
            reportedUser = hashMap.get(key).get(1);

            if (reported.containsKey(user)) {
                reported.get(user).add(reportedUser);
            } else {
                reported.put(user, new ArrayList<>(Arrays.asList(reportedUser)));
            }

            if (reportedCnt.containsKey(reportedUser)) {
                reportedCnt.put(reportedUser, reportedCnt.get(reportedUser) + 1);
            } else {
                reportedCnt.put(reportedUser, 1);
            }
        }

        // 신고된 회원 수
        for (int i = 0; i < id_list.length; i++) {
           if (reported.containsKey(id_list[i])) {
               ArrayList<String> reportedUsers = new ArrayList<>();
               reportedUsers = reported.get(id_list[i]);
               for (int j = 0; j < reportedUsers.size(); j++) {
                   if (reportedCnt.get(reportedUsers.get(j)) >= k) {
                       answer[i] += 1;
                   }
               }
           }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = { "muzi", "frodo", "apeach", "neo" };
        String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };

        // String[] id_list = {"con", "ryan"};
        // String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};

        ReportResult reportResult = new ReportResult();
        reportResult.solution(id_list, report, 2);
    }
}