package baekjoon.samsung;

import java.io.*;
import java.util.*;

public class Q14503 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int answer = 1;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        map[x][y] = 2; // 청소 완료 표시
        dfs(x, y, dir, map);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int dir, int[][] map) {
        int count = 0;
        int nx = x;
        int ny = y;

        while(count < 4) {
            // 방향 전환하기
            if(dir - 1 < 0) {
                dir = 3;
            } else {
                dir -= 1;
            }
            count++;
            nx += dx[dir];
            ny += dy[dir];

            // 가야하는 방향이 올바르지 않은 경우 다시 돌아가기
            if(!check(nx,ny) || map[nx][ny] == 1 || map[nx][ny] == 2) {
                nx -= dx[dir];
                ny -= dy[dir];
                continue;
            }

            answer++;
            map[nx][ny] = 2; // 청소 완료 표시
            dfs(nx, ny, dir, map);
            return;
        }

        // 후진하기
        nx -= dx[dir];
        ny -= dy[dir];
        if(!check(nx,ny) || map[nx][ny] == 1) { // 후진했을 때 벽인 경우
            return;
        }
        dfs(nx, ny, dir, map);
    }

    // 범위 확인하는 메소드
    public static boolean check(int x, int y) {
        if(x < 0 || x > n - 1 || y < 0 || y > m - 1) {
            return false;
        }
        return true;
    }
}