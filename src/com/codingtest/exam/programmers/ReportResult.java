package com.codingtest.exam.programmers;

/**
 * ReportResult
 */
import java.util.*;

public class ReportResult {

    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        HashMap<String, ArrayList<String>> users = new HashMap<>();
        HashMap<String, Integer> reported = new HashMap<>();

        // 중복 신고 제거
        for (int i = 0; i < report.length; i++) {
            String[] splited = report[i].split(" ");
            users.put(report[i], new ArrayList<String>(List.of(splited)));
        }

        for (String key : users.keySet()) {
            String reportedUser = users.get(key).get(1);
            if (reported.containsKey(reportedUser)) {
                reported.put(reportedUser, reported.get(reportedUser) + 1);
            } else {
                reported.put(reportedUser, 1);
            }
        }

        System.out.println(reported);

        return null;
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