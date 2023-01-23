package chap05.sec01;

import java.util.ArrayList;
import java.util.Scanner;

public class P13023_친구관계파악하기 {
    static boolean visited[];
    static ArrayList<Integer>[] arr;
    static boolean arrive;
    public static void main(String[] args) {
        int n; // 노드 개수
        int m; // 에지 개수
        arrive = false;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new ArrayList[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[s].add(e);
            arr[e].add(s);
        }

        for(int i = 0; i < n; i++) {
            DFS(i, 1); // depth 1부터 시작
            if(arrive) break;
        }

        if(arrive) System.out.println("1");
        else System.out.println("0"); // 5의 깊이가 없다면 0 출력
    }

    public static void DFS(int now, int depth) { // DFS 구현하기
        if(depth == 5 || arrive) { // depth가 5가 되면 프로그램 종료
            arrive = true;
            return;
        }
        visited[now] = true;
        for(int i : arr[now]) {
            if(!visited[i]) {
                DFS(i, depth + 1); // 재귀 호출이 될 때마다 depth를 1씩 증가
            }
        }
        visited[now] = false;
    }
}
