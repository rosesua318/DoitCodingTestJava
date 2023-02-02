package chap08.sec05;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge2 {
    int start, end, price; // 시작점, 도착점, 걸리는 시간
    public Edge2(int start, int end, int price) {
        this.start = start;
        this.end = end;
        this.price = price;
    }
}

public class P1219_세일즈맨의고민 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, sCity, eCity;
    static long distance[], cityMoney[];
    static Edge2 edges[];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sCity = Integer.parseInt(st.nextToken());
        eCity = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new Edge2[m];
        distance = new long[n];
        cityMoney = new long[n];
        Arrays.fill(distance, Long.MIN_VALUE); // 최단 거리 배열 초기화하기
        for(int i = 0; i < m; i++) { // 에지 리스트에 데이터 저장하기
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges[i] = new Edge2(start, end, price);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            cityMoney[i] = Long.parseLong(st.nextToken());
        }

        // 변형된 벨만-포드 알고리즘 수행하기
        distance[sCity] = cityMoney[sCity];
        // 양수 사이클이 전파되도록 충분히 큰 수로 반복하기
        for(int i = 0; i <= n + 100; i++) {
            for(int j = 0; j < m; j++) {
                int start = edges[j].start;
                int end = edges[j].end;
                int price = edges[j].price;
                // 출발 노드가 방문하지 않은 노드이면 skip
                if(distance[start] == Long.MIN_VALUE) {
                    continue;
                }
                // 출발 노드가 양수 사이클에 연결된 노드라면 종료 노드도 연결 노드로 업데이트
                else if(distance[start] == Long.MAX_VALUE) {
                    distance[end] = Long.MAX_VALUE;
                }
                // 더 많은 돈을 벌 수 있는 새로운 경로가 발견됐을 때 새로운 경로 값으로 업데이트
                else if(distance[end] < distance[start] + cityMoney[end] - price) {
                    distance[end] = distance[start] + cityMoney[end] - price;
                    // n - 1 반복 이후 업데이트되는 종료 노드는 양수 사이클 연결 노드로 변경
                    if(i >= n - 1) {
                        distance[end] = Long.MAX_VALUE;
                    }
                }
            }
        }
        if(distance[eCity] == Long.MIN_VALUE) {
            System.out.println("gg"); // 도착 불가능
        }
        // 양수 사이클 연결돼 무한대 돈을 벌 수 있을 때
        else if(distance[eCity] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else {
            System.out.println(distance[eCity]); // 이외의 경우
        }
    }
}
