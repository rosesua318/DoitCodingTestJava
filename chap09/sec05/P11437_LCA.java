package chap09.sec05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P11437_LCA {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드의 수
        tree = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++) { // 인접 리스트에 그래프 데이터 저장하기
            int s = sc.nextInt();
            int e = sc.nextInt();
            tree[s].add(e);
            tree[e].add(s);
        }
        depth = new int[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        bfs(1); // depth를 BFS를 이용해 구하기
        int m = sc.nextInt(); // 질의의 수
        for(int i = 0; i < m; i++) {
            // 공통 조상을 구할 두 노드
            int a = sc.nextInt();
            int b = sc.nextInt();
            int lca = executeLCA(a, b);
            System.out.println(lca);
        }
    }

    static int executeLCA(int a, int b) {
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        while(depth[a] != depth[b]) { // 두 노드의 depth 맞추기
            a = parent[a];
        }
        while(a != b) { // 같은 조상이 나올 때까지 한 칸씩 올리기
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    // bfs 구현하기
    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1;
        int count = 0;
        while(!queue.isEmpty()) {
            int now_node = queue.poll();
            for(int next : tree[now_node]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[next] = now_node; // 부모 노드 저장하기
                    depth[next] = level; // 노드 depth 저장하기
                }
            }
            count++;
            if(count == now_size) {
                count = 0;
                now_size = queue.size();
                level++;
            }
        }
    }
}
