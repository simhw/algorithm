package com.codingtest.exam.programmers.level2;

import java.util.*;

public class SearchRank {

    static String[] visited = new String[4];
    static String[] infos;
    static int score = 0;
    static Map<String, ArrayList<Integer>> group = new HashMap<>();

    public int[] solution(String[] info, String[] query) {

        int[] answer = new int[query.length];

        // 1. 모든 지원자들을 분류한 후 같은 그룹의 지원자끼리 묶어둔다.
        for (int i = 0; i < info.length; i++) {
            infos = info[i].split(" ");
            score = Integer.parseInt(infos[4]);
            grouping(0);
        }

        // 2. 해당 그룹에서 점수를 기준으로 오름차순 정렬한다.
        for (String key : group.keySet()) {
            group.get(key).sort(null);
        }
        
        // 3. 미리 분류해둔 그룹에서 X점 이상 맞은 지원자 수를 세준다. (binary search 사용)        
        String[] target = new String[2];
        for (int i = 0; i < query.length; i++) { 
            query[i] = query[i].replaceAll(" and ", "");
            target = query[i].split(" "); 
            answer[i] = lowerbound(group.get(target[0]), Integer.parseInt(target[1]));
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public void grouping(int k) {
        if (k == 4) {
            String key = String.join("", visited);
            ArrayList<Integer> values = group.getOrDefault(key, new ArrayList<>());
            values.add(score);
            group.put(key, values);
        } else {
            visited[k] = infos[k];
            grouping(k + 1);
            visited[k] = "-";
            grouping(k + 1);
        }
    }

    public int lowerbound(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
                
        int mid = 0;        

        while (right > left) {
            mid = (left + right) / 2;
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.size() - right;
    }

    public static void main(String[] args) {
        SearchRank searchRank = new SearchRank();
        String[] info = new String[] {
                "java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"
        };
        String[] query = new String[] {
                "java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"
        };
        searchRank.solution(info, query);
    }
}
