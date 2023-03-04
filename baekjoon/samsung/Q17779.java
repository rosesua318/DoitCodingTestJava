package baekjoon.samsung;

import java.util.*;
import java.io.*;

public class Q17779 {
    static int n;
    static int[][] arr;
    static int total = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                total += arr[i][j];
            }
        }

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                for(int d1 = 1; d1 < n; d1++) {
                    for(int d2 = 1; d2 < n; d2++) {
                        if(x + d1 + d2 >= n) {
                            continue;
                        }
                        if(y - d1 < 0 || y + d2 >= n) {
                            continue;
                        }
                        solution(x, y, d1, d2);
                    }
                }
            }
        }
        System.out.println(min);
    }

    static void solution(int x, int y, int d1, int d2) {
        boolean[][] checked = new boolean[n][n];
        for(int i = 0; i <= d1; i++) {
            checked[x + i][y - i] = true;
            checked[x + d2 + i][y + d2 - i] = true;
        }
        for(int i = 0; i <= d2; i++) {
            checked[x + i][y + i] = true;
            checked[x + d1 + i][y - d1 + i] = true;
        }

        int[] sum = new int[5];
        // 1구역
        for(int i = 0; i < x + d1; i++) {
            for(int j = 0; j <= y; j++) {
                if(checked[i][j]) {
                    break;
                }
                sum[0] += arr[i][j];
            }
        }

        // 2구역
        for(int i = 0; i <= x + d2; i++) {
            for(int j = n - 1; j > y; j--) {
                if(checked[i][j]) {
                    break;
                }
                sum[1] += arr[i][j];
            }
        }

        // 3구역
        for(int i = x + d1; i < n; i++) {
            for(int j = 0; j < y - d1 + d2; j++) {
                if(checked[i][j]) {
                    break;
                }
                sum[2] += arr[i][j];
            }
        }

        // 4구역
        for(int i = x + d2 + 1; i < n; i++) {
            for(int j = n - 1; j >= y - d1 + d2; j--) {
                if(checked[i][j]) {
                    break;
                }
                sum[3] += arr[i][j];
            }
        }

        // 5구역
        sum[4] = total;

        for(int i = 0; i < 4; i++) {
            sum[4] -= sum[i];
        }

        Arrays.sort(sum);

        // 최대 - 최소
        min = Math.min(min, sum[4] - sum[0]);
    }
}