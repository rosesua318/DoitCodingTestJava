package chap09.sec01;

import java.util.ArrayList;
import java.util.Scanner;

public class P1068_리프노드 {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int answer = 0;
    static int deleteNode = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new ArrayList[n];
        visited = new boolean[n];
        int root = 0;
        for(int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++) {
            int p = sc.nextInt();
            if(p != -1) {
                tree[i].add(p);
                tree[p].add(i);
            } else {
                root = i;
            }
        }

        deleteNode = sc.nextInt();
        if(deleteNode == root) {
            System.out.println(0);
        } else {
            DFS(root);
            System.out.println(answer);
        }
    }

    static void DFS(int number) {
        visited[number] = true;
        int cNode = 0;
        for(int i : tree[number]) {
            if(visited[i] == false && i != deleteNode) { // 삭제 노드일 때도 탐색 중지
                cNode++;
                DFS(i);
            }
        }
        if(cNode == 0) {
            answer++; // 자식 노드가 아닐 때 리프 노드로 간주하고 정답값 증가
        }
    }
}
