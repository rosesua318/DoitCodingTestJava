package baekjoon.samsung;

import java.io.*;
import java.util.*;

public class Q19238 {
    static int n, m, f;
    static int board[][];
    static Passesnger[] passengers;
    static Queue<Integer>[][] pq;
    static Taxi taxi;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    static class Passesnger {
        int sx, sy, ex, ey, index;
        public Passesnger(int sx, int sy, int ex, int ey, int index) {
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
            this.index = index;
        }
    }

    static class Taxi implements Comparable<Taxi> {
        int x, y, time;

        public Taxi(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public int compareTo(Taxi o) {
            if(this.time == o.time) {
                if(this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        // 벽이 있는것만 고려
        board = new int[n + 1][n + 1];
        passengers = new Passesnger[m + 1];
        // 승객들만 있는 board
        pq = new LinkedList[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 1; j <= n; j++) {
                pq[i][j] = new LinkedList<Integer>();
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) {
                    board[i][j] = -1;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        taxi = new Taxi(x, y, 0);
        for(int i = 1 ; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            // 승객들 board에 index 넣기
            pq[sx][sy].add(i);
            // 승객 정보 저장 출발 x, 출발 y, 도착 x, 도착 y, index
            passengers[i] = new Passesnger(sx, sy, ex, ey, i);
        }

        for(int i = 0; i < m; i++) {
            // 태울 승객 찾기
            if(!searchPassenger()) {
                System.out.println(-1);
                return;
            }
            // 출발승객을 찾는데 걸린 시간
            int startTime = taxi.time;
            // 출발지와 목적지가 서로 다른상황
            int index = pq[taxi.x][taxi.y].poll();
            // 목적지 찾기 도달할 수 없다면 -1 출력
            if(!goDest(passengers[index].ex, passengers[index].ey)) {
                System.out.println(-1);
                return;
            }
            // 출발 고객 찾는시간 + 도착지 도달한 시간
            f -= taxi.time;

            if(f < 0) {
                System.out.println(-1);
                return;
            }
            else {
                f += (2 * (taxi.time - startTime));
                taxi.time = 0;
            }
        }
        System.out.println(f);
    }

    private static boolean goDest(int ex, int ey) {
        Queue<Taxi> queue = new LinkedList<>();
        queue.offer(taxi);
        boolean[][] visited = new boolean[n + 1][n + 1];
        visited[taxi.x][taxi.y] = true;

        while(!queue.isEmpty()) {
            Taxi cur = queue.poll();
            if(cur.x == ex && cur.y == ey) {
                taxi = cur;
                return true;
            }
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 1 || ny < 1 || nx > n || ny > n || visited[nx][ny] || board[nx][ny] == -1) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new Taxi(nx, ny, cur.time + 1));
            }
        }
        return false;
    }

    private static boolean searchPassenger() {
        ArrayList<Taxi> candidatePassengers = new ArrayList<>();
        Queue<Taxi> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][n + 1];
        queue.offer(taxi);
        visited[taxi.x][taxi.y] = true;
        while(!queue.isEmpty()) {
            Taxi cur = queue.poll();

            if(!candidatePassengers.isEmpty() && candidatePassengers.get(0).time < cur.time) {
                continue;
            }
            // 시간이 덜 걸린다면 add
            if(!pq[cur.x][cur.y].isEmpty()) {
                candidatePassengers.add(cur);
                continue;
            }
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 1 || nx > n || ny < 1 || ny > n || visited[nx][ny] || board[nx][ny] == -1) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new Taxi(nx, ny, cur.time + 1));
            }
        }
        if(candidatePassengers.isEmpty()) {
            return false;
        }
        // 정렬해서 한번 더 검사
        Collections.sort(candidatePassengers);
        taxi = candidatePassengers.get(0);
        return true;
    }
}