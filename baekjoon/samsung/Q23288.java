package baekjoon.samsung;

import java.io.*;
import java.util.*;

public class Q23288 {
    static int n, m, k;
    static int answer;
    static Dice dice;
    static int[] points;
    static int[][] group;
    static int[][] map;
    static int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
    static int[] dy = { 0, 1, 0, -1 }; //

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Dice {
        int x;
        int y;
        int dir;
        int top, bot, left, right, front, back;

        public Dice(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public void setBot(int bot) {
            this.bot = bot;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public void setFront(int front) {
            this.front = front;
        }

        public void setBack(int back) {
            this.back = back;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        group = new int[n + 1][m + 1];
        points = new int[401];

        dice = new Dice(1,1,1);
        dice.setTop(1);
        dice.setFront(2);
        dice.setRight(3);
        dice.setLeft(4);
        dice.setBack(5);
        dice.setBot(6);

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int groupNum = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(group[i][j] < 1) {
                    bfs(i, j, map[i][j], groupNum++);
                }
            }
        }

        while(k-- > 0) {
            move();
        }
        System.out.print(answer);
    }
    static void move() {
        int nx = dice.x + dx[dice.dir];
        int ny = dice.y + dy[dice.dir];

        if(!isValid(nx, ny)) {
            dice.dir = (dice.dir + 2) % 4;
            nx = dice.x + dx[dice.dir];
            ny = dice.y + dy[dice.dir];
        }

        roll(dice.dir);
        dice.x = nx;
        dice.y = ny;

        int current = group[dice.x][dice.y];
        answer += points[current];

        int bot = dice.bot;
        int tile = map[dice.x][dice.y];
        if(bot > tile) {
            dice.dir = (dice.dir + 1) % 4;
        } else if(bot < tile) {
            dice.dir = (dice.dir + 3) % 4;
        }
    }
    static void roll(int dir) {
        int tmpTop = dice.top;
        int tmpBot = dice.bot;
        int tmpLeft = dice.left;
        int tmpRight = dice.right;
        int tmpFront = dice.front;
        int tmpBack = dice.back;
        if(dir == 0) {
            dice.setTop(tmpBack);
            dice.setBot(tmpFront);
            dice.setFront(tmpTop);
            dice.setBack(tmpBot);
        }
        else if(dir == 1) {
            dice.setTop(tmpLeft);
            dice.setBot(tmpRight);
            dice.setLeft(tmpBot);
            dice.setRight(tmpTop);
        }
        else if(dir == 2) {
            dice.setTop(tmpFront);
            dice.setBot(tmpBack);
            dice.setFront(tmpBot);
            dice.setBack(tmpTop);
        }
        else {
            dice.setTop(tmpRight);
            dice.setBot(tmpLeft);
            dice.setLeft(tmpTop);
            dice.setRight(tmpBot);
        }
    }
    static void bfs(int i, int j, int val, int groupNum) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        int count = 0;
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            if(group[cur.x][cur.y] > 0) {
                continue;
            }
            count++;
            group[cur.x][cur.y] = groupNum;

            for(int idx = 0; idx < 4; idx++) {
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                if(!isValid(nx, ny) || group[nx][ny] > 0 || val != map[nx][ny]) {
                    continue;
                }
                queue.add(new Point(nx, ny));
            }
        }
        points[groupNum] = count * val;
    }
    static boolean isValid(int x, int y)
    {
        return x > 0 && y > 0 && x <= n && y <= m;
    }
}