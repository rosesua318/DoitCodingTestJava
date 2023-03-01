package baekjoon.samsung;

import java.util.*;
import java.io.*;

public class Q19236 {
    public static int[][] map; // 전체 맵
    public static Fish[] fish; // 물고기 정보 저장
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상, 상좌, 좌, 좌하, 하, 하우, 우, 상우
    public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int answer = 0;

    static class Fish {
        int num;
        int x;
        int y;
        int dir;
        int status; // 0 : 죽음, 1 : 살아있음

        Fish(int num, int x, int y, int dir, int status) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.status = status;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[4][4];
        fish = new Fish[17];

        for(int i = 0; i < 4; i++) {
            st  = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken()); // 물고기 번호
                int dir = Integer.parseInt(st.nextToken()) - 1; // 물고기 방향
                fish[num] = new Fish(num, i, j, dir, 1);
                map[i][j] = num; // 맵에 물고기 번호 저장
            }
        }

        int sx = 0, sy = 0; //상어의 위치
        int sd = fish[map[0][0]].dir; // 초기 상어의 방향
        int eat = map[0][0]; // 먹은 물고기 번호 합 저장 변수
        fish[map[0][0]].status = 0; // (0, 0) 물고기 죽음
        map[0][0] = -1; // 상어가 있는 위치 -1

        dfs(sx, sy, sd, eat);

        System.out.println(answer);
    }

    public static void dfs(int sx, int sy, int sd, int eat) {
        answer = Math.max(answer, eat);

        //map 배열 복사
        int[][] tmap = new int[map.length][map.length];
        for(int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, tmap[i], 0, map.length);
        }

        //fish 배열 복사
        Fish[] tfish = new Fish[fish.length];
        for(int i = 1; i <= 16; i++)
            tfish[i] = new Fish(fish[i].num, fish[i].x, fish[i].y, fish[i].dir, fish[i].status);

        // 물고기 이동
        moveFish();

        // 상어 이동
        for(int i = 1; i < 4; i++) { // 4*4 행렬로 1칸, 2칸, 3칸까지 최대로 이동 가능
            int nx = sx + dx[sd] * i;
            int ny = sy + dy[sd] * i;

            if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != 0) {
                int eatFish = map[nx][ny];
                int nd = fish[eatFish].dir;
                map[sx][sy] = 0;
                map[nx][ny] = -1;
                fish[eatFish].status = 0;

                dfs(nx, ny, nd, eat + eatFish);

                fish[eatFish].status = 1;
                map[sx][sy] = -1;
                map[nx][ny] = eatFish;
            }
        }

        // 맵 상태, 물고기 정보 되돌리기
        for(int j = 0; j < map.length; j++)
            System.arraycopy(tmap[j], 0, map[j], 0, map.length);

        for(int i=1; i<=16; i++)
            fish[i] = new Fish(tfish[i].num, tfish[i].x, tfish[i].y, tfish[i].dir, tfish[i].status);
    }

    // 물고기 이동
    public static void moveFish() {
        for(int i = 1; i < 17; i++) {
            if(fish[i].status == 0) {
                continue;
            }

            int cnt = 0;
            int dir = fish[i].dir;// 현재 i번째 물고기의 방향
            int nx = 0, ny = 0; // 물고기가 이동할 칸의 x, y값

            while(cnt < 8) { // 45도 방향 바꾸며 반복
                dir %= 8; // 방향 범위 넘어가는 걸 막기 위해 나머지 연산
                fish[i].dir = dir;

                nx = fish[i].x + dx[dir]; // 방향에 맞게 좌표 이동
                ny = fish[i].y + dy[dir];

                if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != -1) {
                    if(map[nx][ny] == 0) { // 이동할 위치가 빈칸일 경우
                        map[fish[i].x][fish[i].y] = 0; // 기존 위치 빈칸으로
                        fish[i].x = nx;
                        fish[i].y = ny;
                        map[nx][ny] = i;
                    } else { // 이동할 위치에 다른 물고기가 있을 경우
                        // 바꿀 물고기 위치 변경
                        int changeFish = fish[map[nx][ny]].num;
                        fish[changeFish].x = fish[i].x;
                        fish[changeFish].y = fish[i].y;
                        map[fish[changeFish].x][fish[changeFish].y] = changeFish;

                        // 현재 물고기 위치 변경
                        fish[i].x = nx;
                        fish[i].y = ny;
                        map[nx][ny] = i;
                    }
                    break;
                } else {
                    dir++;
                    cnt++;
                }
            }
        }
    }

}