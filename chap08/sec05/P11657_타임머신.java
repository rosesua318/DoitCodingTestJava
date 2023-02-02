package chap08.sec05;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge { // 에지 리스트를 편하게 다루기 위해 클래스로 별도 구현하기
    int start, end, time; // 시작점, 도착점, 걸리는 시간
    public Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}

public class P11657_타임머신 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static long distance[];
    static Edge edges[];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new Edge[m + 1];
        distance = new long[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE); // 최단 거리 배열 초기화하기
        for(int i = 0; i < m; i++) { // 에지 리스트에 데이터 저장하기
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }

        // 벨만-포드 알고리즘 수행하기
        distance[1] = 0;
        for(int i = 1; i < n; i++) { // n보다 1개 적은 수만큼 반복하기
            for(int j = 0; j < m; j++) {
                Edge edge = edges[j];
                // 더 작은 최단 거리가 있을 때 업데이트하기
                if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }
        boolean myCycle = false;
        for(int i = 0; i < m; i++) { // 음수 사이클 확인하기
            Edge edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
                myCycle = true;
            }
        }

        if(!myCycle) { // 음수 사이클이 없을 때
            for(int i = 2; i <= n; i++) {
                if(distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else { // 음의 사이클이 있을 때
            System.out.println("-1");
        }
    }
}
