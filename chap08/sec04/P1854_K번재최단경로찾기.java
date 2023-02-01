package chap08.sec04;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 노드 클래스 작성하기
class Node2 implements Comparable<Node2> {
    int node;
    int cost;
    Node2(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node2 o) {
        return this.cost < o.cost ? -1 : 1;
    }
}
public class P1854_K번재최단경로찾기 {
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        int n, m, k;
        int[][] w = new int[1001][1001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] distQueue = new PriorityQueue[n + 1];
        Comparator<Integer> cp = new Comparator<Integer>() { // 오름차순 정렬 기준 설정
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };
        for(int i = 0; i < n + 1; i++) {
            distQueue[i] = new PriorityQueue<Integer>(k, cp);
        }
        for(int i = 0; i < m; i++) { // 인접 행렬에 그래프 데이터 저장하기
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            w[a][b] = c;
        }
        PriorityQueue<Node2> pq = new PriorityQueue<>();
        pq.add(new Node2(1, 0));
        distQueue[1].add(0);
        while(!pq.isEmpty()) {
            Node2 u = pq.poll();
            for(int adjNode = 1; adjNode <= n; adjNode++) {
                // 연결된 모드 노드로 검색하기(시간 복잡도 측면에서 인접 행렬이 불리한 이유)
                if(w[u.node][adjNode] != 0) {
                    // 저장된 경로가 K개가 안될 때는 그냥 추가하기
                    if(distQueue[adjNode].size() < k) {
                        distQueue[adjNode].add(u.cost + w[u.node][adjNode]);
                        pq.add(new Node2(adjNode, u.cost + w[u.node][adjNode]));
                    }
                    // 저장된 노드가 K개 이고, 현재 가장 큰 값 보다 작을 때만 추가하기
                    else if(distQueue[adjNode].peek() > u.cost + w[u.node][adjNode]) {
                        distQueue[adjNode].poll(); // 기존 큐에서 Max값 먼저 삭제해야 함
                        distQueue[adjNode].add(u.cost + w[u.node][adjNode]);
                        pq.add(new Node2(adjNode, u.cost + w[u.node][adjNode]));
                    }
                }
            }
        }
        for(int i = 1; i<= n; i++) { // K번째 경로 출력하기
            if(distQueue[i].size() == k) {
                bw.write(distQueue[i].peek() + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
