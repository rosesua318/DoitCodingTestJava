package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Q2422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] pairs = new boolean[n + 1][n + 1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pairs[a][b] = true;
            pairs[b][a] = true;
        }

        int result = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = i + 1; j <= n; j++) {
                if(pairs[i][j]) continue;
                for(int k = j + 1; k <= n; k++) {
                    if(!pairs[j][k] && !pairs[k][i]){ // 새로 뽑은 것과 1, 2번째로 뽑은 것이 맞지 않을 때
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}