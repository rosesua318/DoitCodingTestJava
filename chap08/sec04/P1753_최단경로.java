package chap08.sec04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int vertex, value;
    Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.value > o.value) {
            return 1;
        } else {
            return -1;
        }
    }
}
public class P1753_최단경로 {
    public static int v, e, k;
    public static int distance[];
    public static boolean visited[];
    public static ArrayList<Edge> list[];
    public static PriorityQueue<Edge> q = new PriorityQueue<Edge>(); // 자동으로 거리가 최소인 노드를 선택하게 함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        distance = new int[v + 1];
        visited = new boolean[v + 1];
        list = new ArrayList[v + 1];
        for(int i = 1; i <= v; i++) {
            list[i] = new ArrayList<Edge>();
        }
        for(int i = 0; i <= v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < e; i++) { // 가중치가 있는 인접 리스트 초기화하기
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }
        q.add(new Edge(k, 0)); // K를 시작점으로 설정하기
        distance[k] = 0;
        while(!q.isEmpty()) {
            Edge current = q.poll();
            int c_v = current.vertex;
            if(visited[c_v]) {
                continue; // 이미 방문한 적이 있는 노드는 다시 큐에 넣지 않음
            }
            visited[c_v] = true;

            for(int i = 0; i < list[c_v].size(); i++) {
                Edge tmp = list[c_v].get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                if(distance[next] > distance[c_v] + value) { // 최소 거리로 업데이트하기
                    distance[next] = value + distance[c_v];
                    q.add(new Edge(next, distance[next]));
                }
            }
        }

        for(int i = 1; i <= v; i++) { // 거리 배열 출력하기
            if(visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}
