package chap11.sec01;

import java.io.IOException;
import java.util.Scanner;

public class P11049_행렬곱연산횟수의최솟값 {
    // 행렬 정보 저장 클래스
    static class Matrix {
        private int y;
        private int x;
        Matrix(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int n;
    static Matrix[] m;
    static int[][] d;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = new Matrix[n + 1];
        d = new int[n + 1][n + 1];
        for(int i = 0; i < d.length; i++) {
            for(int j = 0; j < d[i].length; j++) {
                d[i][j] = -1;
            }
        }
        for(int i = 1; i <= n; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            m[i] = new Matrix(y, x);
        }
        System.out.println(excute(1, n));
    }
    // 톱-다운 방식으로 점화식 함수 구현하기
    static int excute(int s, int e) {
        int result = Integer.MAX_VALUE;
        if(d[s][e] != -1) { // 계산했던 부분이면 다시 계산하지 않음(메모이제이션)
            return d[s][e];
        }
        if(s == e) { // 행렬 1개의 곱셈 연산의 수
            return 0;
        }
        if(s + 1 == e) { // 행렬 2개의 곱셈 연산의 수
            return m[s].y * m[s].x * m[e].x;
        }
        for(int i = s; i < e; i++) { // 행렬이 3개 이상일 때 곱셈 연산 수 -> 점화식 처리
            result = Math.min(result, m[s].y * m[i].x * m[e].x + excute(s, i) + excute(i + 1, e));
        }
        return d[s][e] = result;
    }
}
