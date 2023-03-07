package baekjoon.samsung;

import java.util.*;
import java.io.*;

public class Q14502 {
    public static int[][] map;
    public static int[][] temp;
    public static int n, m;
    public static ArrayList<Point> arr = new ArrayList<>();
    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, -1, 0, 1 };
    public static int answer = 0;

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        temp = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    arr.add(new Point(i, j)); // 바이러스 위치 추가
                }
            }
        }

        dfs(0);
        System.out.println(answer);
    }

    // 모든 벽을 세우는 조합을 구하기 위함
    public static void dfs(int depth) {
        if(depth == 3) { // 3개의 벽 다 세운 경우
            for(int i = 0; i < map.length; i++) {
                temp[i] = map[i].clone();
            }
            bfs(); // 바이러스 퍼뜨리기
            return;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1; // 벽을 세우는 경우
                    dfs(depth + 1);
                    map[i][j] = 0; // 벽을 세우지 않는 경우
                }
            }
        }
    }

    // 바이러스 퍼뜨리기
    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < arr.size(); i++) {
            queue.add(arr.get(i));
        }
        while(!queue.isEmpty()) {
            Point virus = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];
                // 빈칸을 만난 경우 바이러스 퍼뜨리기
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        // 안전 영역(빈칸 0) 구하기
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(temp[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }
}