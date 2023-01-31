package chap08.sec03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2252_줄세우기 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        int[] indegree = new int[n + 1]; // 진입 차수 배열
        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.get(s).add(e);
            indegree[e]++; // 진입 차수 배열 데이터 저장하기
        }

        Queue<Integer> queue = new LinkedList<>(); // 위상 정렬 수행하기
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for(int next : arr.get(now)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
