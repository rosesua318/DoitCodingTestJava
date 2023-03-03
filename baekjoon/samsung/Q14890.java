package baekjoon.samsung;

import java.io.*;
import java.util.*;

public class Q14890 {
    public static int n, l;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(check(i, 0, 0)) { // 행 검사
                answer++;
            }

            if(check(0, i, 1)) { // 열 검사
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean check(int x, int y, int d) {
        int[] arr = new int[n];
        boolean[] visited = new boolean[n]; // 경사로 유무

        for(int i = 0; i < n; i++) {
            if(d == 0) {
                arr[i] = map[x][y + i];
            } else {
                arr[i] = map[x + i][y];
            }
        }

        for(int i = 0; i < n - 1; i++) {
            if(Math.abs(arr[i] - arr[i + 1]) > 1) { // 차가 1 보다 큰 경우
                return false;
            } else if(arr[i] - arr[i + 1] == 1) { // 내리막길인 경우
                for(int j = i + 1; j <= i + l; j++) {
                    if(j >= n || arr[i + 1] != arr[j] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            } else if(arr[i + 1] - arr[i] == 1) { // 오르막길인 경우
                for(int j = i; j > i - l; j--) {
                    if(j < 0 || arr[i] != arr[j] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            }
        }
        return true;
    }
}
