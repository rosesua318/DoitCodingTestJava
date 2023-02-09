package chap10.sec01;

import java.util.Scanner;

public class P1947_선물전달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long mod = 1000000000;
        long d[] = new long[1000001];
        d[1] = 0;
        d[2] = 1;
        for(int i = 3; i <= n; i++) {
            d[i] = (i - 1) * (d[i - 1] + d[i - 2]) % mod; // 완전 순열 점화식
        }
        System.out.println(d[n]);
    }
}
