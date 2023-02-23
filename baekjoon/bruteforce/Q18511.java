package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Q18511 {
    private static int[] arr;
    private static int n;
    private static int k;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        arr = new int[k];
        for(int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int now) {
        if(now > n) {
            return;
        }
        if(answer < now) {
            answer = now;
        }
        for(int i = k - 1; i > -1; i--) {
            dfs(now * 10 + arr[i]);
        }
    }
}
