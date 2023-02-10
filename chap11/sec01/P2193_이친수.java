package chap11.sec01;

import java.util.Scanner;

public class P2193_이친수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long d[][] = new long[n + 1][2];
        d[1][1] = 1; // 1자리 이친수는 1 한 가지
        d[1][0] = 0;
        for(int i = 2; i <= n; i++) {
            d[i][0] = d[i - 1][1] + d[i - 1][0];
            d[i][1] = d[i - 1][0];
        }

        System.out.println(d[n][0] + d[n][1]);
    }
}
