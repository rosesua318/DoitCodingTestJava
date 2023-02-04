package chap09.sec01;

import java.util.ArrayList;
import java.util.Scanner;

public class P11725_트리의부모찾기 {
    static int n;
    static boolean[] visited;
    static ArrayList<Integer> tree[];
    static int answer[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n + 1];
        tree = new ArrayList[n + 1];
        answer = new int[n + 1];
        for(int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        DFS(1); // 부모 노드부터 DFS 시작
        for(int i = 2; i <= n ; i++) {
            System.out.println(answer[i]);
        }
    }

    static void DFS(int number) {
        visited[number] = true;
        for(int i : tree[number]) {
            if(!visited[i]) {
                answer[i] = number; // DFS를 탐색하면서 부모 노드를 정답 배열에 저장
                DFS(i);
            }
        }
    }
}
