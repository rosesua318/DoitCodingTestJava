package chap08.sec01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1325_효율적인해킹 {
    static int n, m;
    static boolean visited[];
    static int answer[];
    static ArrayList<Integer>arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        answer = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }

        for(int i = 1; i <= n; i++) { // 모든 노드로 BFS 실행하기
            visited = new boolean[n + 1];
            bfs(i);
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, answer[i]);
        }
        for(int i = 1; i <= n; i++) {
            if(answer[i] == max) { // answer 배열에서 max와 같은 값을 지닌 index가 정답
                System.out.print(i + " ");
            }
        }
    }

    public static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;
        while(!queue.isEmpty()) {
            int now_node = queue.poll();
            for(int i : arr[now_node]) {
                if(visited[i] == false) {
                    visited[i] = true;
                    answer[i]++; // 신규 노드 인덱스의 정답 배열 값을 증가시킴
                    queue.add(i);
                }
            }
        }
    }
}
