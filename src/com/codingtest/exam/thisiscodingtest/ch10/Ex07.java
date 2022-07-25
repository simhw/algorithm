package com.codingtest.exam.thisiscodingtest.ch10;

// 예제 10-9 커리큘럼
// <해결>
// 각 노드(강의)에 대하여 인접한 노드를 확인할 때, 인접한 노드에 대하여 현재보다 강의 시간이 더 긴 경우를 찾는다면,
// 더 오랜 시간이 걸리는 경우의 시간 값을 저장하는 방식으로 결과 테이블 갱신

import java.util.*;

public class Ex07 {  
    static int V;
    static int time[];
    static List<Integer>[] graph;
    static int indegree[];

    static void solution() {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();sc.nextLine();
        // 각 강의 시간을 0 으로 초기화
        time = new int[V + 1];
        // 모든 노드에 대한 진입차수는 0 으로 초기화
        indegree = new int[V + 1];
        // 각 노드에 연결된 간선 정보를 담기 위한 그래프 초기화
        graph = new ArrayList[V + 1];
        // 방향 그래프의 모든 간선 정보를 입력받기
        for (int i = 1; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
            String[] input = sc.nextLine().split(" ");
            time[i] = Integer.parseInt(input[0]);  // 강의 시간
            for (int j = 1; j < input.length; j++) {
                int lecture = Integer.parseInt(input[j]);    // 선수 강의
                if (lecture != -1) {
                    graph[lecture].add(i);
                    indegree[i] += 1;
                }
            }
        }
        sc.close();
        topology();
    }
    static void topology() {
        int[] result = new int[V + 1];
        Queue<Integer> queue = new LinkedList<>();

        // 처음 시작할 때는 진입차수가 0 인 노드를 큐에 삽입
        for (int i = 1; i < V + 1; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int now = queue.poll();
            result[now] = time[now];
            // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (int adj : graph[now]) {
                indegree[adj] -= 1;
                // 새롭게 진입차수가 0 이 되는 노드를 큐에 삽입
                if (indegree[adj] == 0) {
                    time[adj] += time[now];
                    queue.add(adj);
                }
            }
        }
        System.out.println("reuslt = " + Arrays.toString(result));
    }
    public static void main(String[] args) {
        /*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
         */
        solution();
    }
}
