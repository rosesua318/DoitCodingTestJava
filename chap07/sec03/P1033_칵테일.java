package chap07.sec03;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

class cNode {
    int b;
    int p;
    int q;
    public cNode(int b, int p, int q) {
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }
    public int getB() {
        return b;
    }
    public int getP() {
        return p;
    }
    public int getQ() {
        return q;
    }
}
public class P1033_칵테일 {
    static ArrayList<cNode>[] arr;
    static long lcm;
    static boolean visited[];
    static long d[];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        arr = new ArrayList[n];
        visited = new boolean[n];
        d = new long[n];
        lcm = 1;
        for(int i = 0; i < n; i++) {
            arr[i] = new ArrayList<cNode>();
        }
        for(int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            arr[a].add(new cNode(b, p, q));
            arr[b].add(new cNode(a, q, p));
            lcm *= (p * q / gcd(p, q)); // 최소 공배수는 두 수의 곱을 최대 공약수로 나눈 것
        }

        d[0] = lcm;
        dfs(0);
        long mgcd = d[0];
        for(int i = 1; i < n; i++) {
            mgcd = gcd(mgcd, d[i]);
        }
        for(int i = 0; i < n; i++) {
            System.out.print(d[i] / mgcd + " ");
        }
    }

    public static long gcd(long a, long b) { // 최대 공약수 함수 구현하기
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a % b); // 재귀 함수의 형태로 구현
        }
    }

    public static void dfs(int node) { // DFS 구현하기
        visited[node] = true;
        for(cNode i : arr[node]) {
            int next = i.getB();
            if(!visited[next]) {
                d[next] = d[node] * i.getQ() / i.getP(); // 주어진 비율로 다음 노드값 갱신하기
                dfs(next);
            }
        }
    }
}
