package com.codingtest.exam.programmers.level2;

import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;

import java.util.Arrays;

public class SearchRank {
    public int[] solution(String[] info, String[] query) {

        int[] answer = new int[query.length];
        String[] queryArr = new String[4];
        String[] infoArr = new String[4];
        int score = 0;

        for (int i = 0; i < query.length; i++) {
            queryArr = query[i].replaceAll(" and", "").split(" ");
            score = Integer.parseInt(queryArr[4]);
            for (int j = 0; j < info.length; j++) {
                infoArr = info[j].split(" ");
                if (score > Integer.parseInt(infoArr[4])) {
                    continue;
                } else {
                    int k = 0;
                    // info 원소 비교
                    while (k < infoArr.length - 1) {
                        if (infoArr[k].equals(queryArr[k]) || queryArr[k].equals("-")) {
                            k++;
                            if (k == infoArr.length - 1) {
                                answer[i] += 1;
                            }
                        }
                        else break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        SearchRank searchRank = new SearchRank();
        String[] info = new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        searchRank.solution(info, query);
    }
    
}
