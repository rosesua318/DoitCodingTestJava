package chap08.sec01;

import java.util.*;

public class P18352_특정거리도시찾기 {
    static int visited[];
    static ArrayList<Integer>[] arr;
    static int n, m, k, x;
    static List<Integer> answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 노드의 수
        m = sc.nextInt(); // 에지의 수
        k = sc.nextInt(); // 목표 거리
        x = sc.nextInt(); // 시작점
        arr = new ArrayList[n + 1];
        answer = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[s].add(e);
        }
        visited = new int[n + 1]; // 방문 배열 초기화하기
        for(int i = 0; i <= n; i++) {
            visited[i] = -1;
        }

        bfs(x);
        for(int i = 0; i <= n; i++) {
            if(visited[i] == k) {
                answer.add(i);
            }
        }
        if(answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for(int temp : answer) {
                System.out.println(temp);
            }
        }
    }

    // BFS 구현하기
    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node]++;
        while(!queue.isEmpty()) {
            int now_node = queue.poll();
            for(int i : arr[now_node]) {
                if(visited[i] == -1) {
                    visited[i] = visited[now_node] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
