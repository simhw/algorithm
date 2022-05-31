package com.codingtest.exam.programmers.level2;

import java.util.LinkedList;
// Least Recently Used
// 가장 오랫동안 참조되지 않은 페이지를 교체

public class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // Queue
        LinkedList<String> cache = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            boolean exist = false;
            if (cacheSize == 0) {
                answer += 5;
            } else {
                for (int j = 0; j < cache.size(); j++) {
                    if (cache.get(j).equalsIgnoreCase(cities[i])) {
                        answer += 1;    // cache hit
                        exist = true;
                        cache.remove(cache.get(j));
                    }
                }
                if (exist == false) {
                    answer += 5;    // cache miss
                    if (cache.size() >= cacheSize) {
                        cache.remove(0);
                    }
                    // 캐시 공간이 남았을 경우 데이터 삭제없이 추가
                }
                cache.add(cities[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Cache cache = new Cache();
        cache.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"});
    }

}
