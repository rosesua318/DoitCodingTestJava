package chap10.sec01;

import java.util.Scanner;

public class P11050_이항계수 {
    static int n, k;
    static int[][] d;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        d = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            d[i][1] = i;
            d[i][0] = 1;
            d[i][i] = 1;
        }
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                d[i][j] = d[i - 1][j] + d[i - 1][j - 1]; // 조합 기본 점화식
            }
        }

        System.out.println(d[n][k]);
    }
}
