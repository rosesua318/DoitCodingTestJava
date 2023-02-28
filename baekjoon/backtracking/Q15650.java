package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Q15650 {
    private static boolean[] visited;
    private static int[] answer;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        answer = new int[m];
        sb = new StringBuilder();

        dfs(n, m, 0, 1);

        System.out.println(sb.toString());
    }

    private static void dfs(int n, int m, int index, int at) {
        if(index == m) {
            for(int num : answer) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = at; i <= n; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                answer[index] = i;
                dfs(n, m, index + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}