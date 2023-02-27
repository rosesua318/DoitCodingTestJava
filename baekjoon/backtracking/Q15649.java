package baekjoon.backtracking;

import java.util.*;

public class Q15649 {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];
        arr = new int[m + 1];
        dfs(0);
    }

    private static void dfs(int index) {
        if(index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[index] = i;
                dfs(index + 1); // arr의 인덱스를 +1 시켜주기
                visited[i] = false; // 백트래킹
            }
        }
    }
}