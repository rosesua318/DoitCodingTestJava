package baekjoon.samsung;

import java.io.*;
import java.util.*;

public class Q15684 {
    static int n, m, h;
    static int[][] ladder;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        ladder = new int[h + 1][n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ladder[r][c] = 1;
        }

        for(int i = 0; i <= 3; i++) {
            comb(1, 0, i);
        }
        System.out.println(-1);
    }

    static void comb(int nr, int count, int size) {
        if(count == size) {
            if(check()) { // 사다리가 옳게 놓였는지 확인
                System.out.println(size);
                System.exit(0);
            }
            return;
        }

        for(int r = nr; r <= h; r++) { // 행의 이전 값 제외하고 현재부터 확인
            for(int c = 1; c < n; c++) { // 사다리를 현재 위치에 놓을 수 있는지 확인
                if(ladder[r][c] == 1) { // 현재 위치가 사다리인 경우
                    continue;
                }
                if(ladder[r][c - 1] == 1) { // 현재 위치의 왼쪽이 사다리인 경우
                    continue;
                }
                if(ladder[r][c + 1] == 1) { // 현재 위치의 다음 위치가 사다리인 경우
                    continue;
                }
                ladder[r][c] = 1; // 사다리 놓기
                comb(r, count + 1, size); // 다음 사다리 놓을 위치 정하기
                ladder[r][c] = 0; // 사다리 없애기 (백트래킹)
            }
        }
    }

    static boolean check() {
        for(int i = 1; i <= n; i++) {
            int current = i;
            int start = 1;
            while(start <= h) {
                if(ladder[start][current] == 1) { // 현재 위치가 사다리인 경우
                    current++; // 오른쪽으로
                    start++;
                } else if(ladder[start][current - 1] == 1) { // 왼쪽이 사다리인 경우
                    current--; // 왼쪽으로
                    start++;
                } else { // 양옆이 사다리가 아닌 경우
                    start++; // 아래로
                }
            }
            if (i != current) {
                return false;
            }
        }
        return true;
    }
}