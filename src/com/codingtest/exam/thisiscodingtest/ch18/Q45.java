package com.codingtest.exam.thisiscodingtest.ch18;

// 최종 순위 
import java.util.*;

public class Q45 {
    static int n, m;
    static int[] indegree;
    static boolean[][] graph;
    static ArrayList<Integer> list = new ArrayList<>();

    static void solution() {
        // 위상 정렬(Topology Sort)
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
            
        // 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        // 위상 정렬 결과가 오직 하나인지의 여부
        boolean certain = true;
        // 그래프 내 사이클이 존재하는지 여부 
        boolean cycle = false; 

        for (int i = 0; i < n; i++) {
            // 큐가 비어 있다면 사이클이 발생했다는 의미
            if (queue.isEmpty()) {
                cycle = true;
                break;
            }

            // 큐의 원소가 2개 이상이라면 가능한 정렬 결과가 여러 개라는 의미
            if (queue.size() >= 2) {
                certain = true;
                break;
            }

            int now = queue.poll();
            result.add(now);
              
            // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (int j = 1; j < n + 1; j++) {
                if (graph[now][j]) {
                    indegree[j] -= 1;
                    // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                    if (indegree[j] == 0) {
                        queue.add(j);
                    }
                }
            }
        }

        // 사이클이 발생하는 경우(일관성이 없는 경우)
        if (cycle)
            System.out.println("IMPOSSIBLE");
        // 위상 정렬 결과가 여러 개인 경우
        else if (!certain)
            System.out.println("?");
        // 위상 정렬을 수행한 결과 출력
        else {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 작년 순위 정보 입력
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            list.add(x);
        }
        
        // '자기보다 낮은 등수를 가진 팀을 가리키도록' 방향 그래프의 간선 정보 초기화   
        indegree = new int[n + 1];
        graph = new boolean[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                graph[list.get(i)][list.get(j)] = true;
                indegree[list.get(j)] += 1;
            }
        }

        // 올해 변경된 순위 정보 입력
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 간선의 방향 뒤집기
            if (graph[a][b]) {
                graph[a][b] = false;
                graph[b][a] = true;
                indegree[a] += 1;
                indegree[b] -= 1;
            } else {
                graph[a][b] = true;
                graph[b][a] = false;
                indegree[a] -= 1;
                indegree[b] += 1;
            }
        }
        solution();
        sc.close();
    }
}
