package chap08.sec03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class dNode {
    int targetNode;
    int value;
    dNode(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }
}

public class P1948_임계경로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<dNode>> arr = new ArrayList<>();
        ArrayList<ArrayList<dNode>> reverseArr = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
            reverseArr.add(new ArrayList<>());
        }
        int[] indegree = new int[n + 1]; // 진입 차수 배열
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr.get(s).add(new dNode(e, v));
            reverseArr.get(e).add(new dNode(s, v)); // 역방향 에지 정보 저장하기
            indegree[e]++; // 진입 차수 배열 초기화하기
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startDosi = Integer.parseInt(st.nextToken());
        int endDosi = Integer.parseInt(st.nextToken());

        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startDosi);
        int[] result = new int[n + 1];
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(dNode next : arr.get(now)) {
                indegree[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.value);
                if(indegree[next.targetNode] == 0) {
                    queue.offer(next.targetNode);
                }
            }
        }

        // 위상 정렬 reverse
        int resultCount = 0;
        boolean visited[] = new boolean[n + 1];
        queue = new LinkedList<>();
        queue.offer(endDosi);
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(dNode next : reverseArr.get(now)) {
                // 1분도 쉬지 않는 도로 체크하기
                if(result[next.targetNode] + next.value == result[now]) {
                    resultCount++;
                    // 중복 카운트 방지를 위해 이미 방문한 적이 있는 노드 제외하기
                    if(visited[next.targetNode] == false) {
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }
            }
        }

        System.out.println(result[endDosi]);
        System.out.println(resultCount);
    }
}
