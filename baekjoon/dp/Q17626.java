package baekjoon.dp;

import java.io.*;

public class Q17626 {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(sc.readLine());
        dp = new int[n + 1];
        solve();
        System.out.println(dp[n]);
    }

    private static void solve() {
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                int index = i - j * j;
                dp[i] = Math.min(dp[i], dp[index] + 1);
            }
        }
    }
}