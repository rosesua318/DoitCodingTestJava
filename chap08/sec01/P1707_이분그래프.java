package chap08.sec01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1707_이분그래프 {
    static ArrayList<Integer>[] arr;
    static int[] check;
    static boolean visited[];
    static boolean isEven;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);
            arr = new ArrayList[v + 1];
            visited = new boolean[v + 1];
            check = new int[v + 1];
            isEven = true;
            for(int j = 1 ; j <= v; j++) {
                arr[j] = new ArrayList<Integer>();
            }
            for(int j = 0; j < e; j++) { // 인접 리스트로 그래프 저장하기
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                arr[start].add(end);
                arr[end].add(start);
            }

            // 주어진 그래프가 1개로 연결돼 있다는 보장이 없으므로 모든 노드에서 수행하기
            for(int j = 1; j <= v; j++) {
                if(isEven) {
                    dfs(j);
                } else {
                    break;
                }
            }

            if(isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void dfs(int node) { // DFS 구현하기
        visited[node] = true;
        for(int i : arr[node]) {
            if(!visited[i]) {
                // 인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리하기
                check[i] = (check[node] + 1) % 2; // 0과 1로만 되게
                dfs(i);
            }
            // 이미 방문한 노드가 현재 내 노드와 같은 집합이면 이분 그래프가 아님
            else if(check[node] == check[i]) {
                isEven = false;
            }
        }
    }
}
