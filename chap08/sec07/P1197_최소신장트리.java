package chap08.sec07;

import java.util.PriorityQueue;
import java.util.Scanner;

class pEdge implements Comparable<pEdge> {
    int s;
    int e;
    int v;
    pEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    @Override
    public int compareTo(pEdge o) {
        // 가중치를 기준으로 오름차순 정렬을 하기 위해 compareTo 재정의하기
        return this.v - o.v;
    }
}

public class P1197_최소신장트리 {
    static int[] parent;
    static PriorityQueue<pEdge> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 수
        int m = sc.nextInt(); // 에지 수
        queue = new PriorityQueue<pEdge>(); // 자동 정렬을 위해 우선순위 큐 자료구조 선택하기
        parent = new int[n + 1];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            queue.add(new pEdge(s, e, v));
        }

        int useEdge = 0;
        int result = 0;
        while(useEdge < n - 1) {
            pEdge now = queue.poll();
            if(find(now.s) != find(now.e)) { // 같은 부모가 아니라면 연결해도 사이클이 생기지 않음
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }

        System.out.println(result);
    }

    // union 연산 : 대표 노드끼리 연결하기
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }

    // find 연산
    public static int find(int a) {
        if(a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]); // 재귀 함수의 형태로 구현 -> 경로 압축 부분
        }
    }
}
