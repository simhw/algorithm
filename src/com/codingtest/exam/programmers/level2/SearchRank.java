package com.codingtest.exam.programmers.level2;

public class SearchRank {
    public int[] solution(String[] info, String[] query) {
        // 0. cpp, java, python
        // 1. backend, frontend
        // 2. junior, senior
        // 3. chicken, pizza 
        String[][] arr = new String[info.length][4];

        for (int i = 0; i < info.length; i++) {
            for (String str : info[i].split(" ")) {
                System.out.println(str);
            }
        }


        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        SearchRank searchRank = new SearchRank();
        String[] info = new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        searchRank.solution(info, query);
    }
    
}
