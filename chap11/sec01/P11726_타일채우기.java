package chap11.sec01;

import java.util.Scanner;

public class P11726_타일채우기 {
    static long mod = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long d[] = new long[1001];
        d[1] = 1; // 길이가 2 x 1일 때 타일의 경우의 수
        d[2] = 2; // 길이가 2 x 2일 때 타일의 경우의 수
        for(int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % mod;
        }
        System.out.println(d[n]);
    }
}
