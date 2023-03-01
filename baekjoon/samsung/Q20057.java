package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q20057 {
    static int n;
    static int[][] board;
    static int[] dx = { 0, 1, 0, -1 };   // x 이동 방향
    static int[] dy = { -1, 0, 1, 0 };   // y 이동 방향
    static int[] dc = { 1, 1, 2, 2 };   // 토네이도가 각 방향으로 이동하는 횟수
    static int[][] dsx = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},    // 모래가 퍼지는 x방향
            {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
    static int[][] dsy = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},    // 모래가 퍼지는 y방향
            {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
    static int[] ratio ={ 1, 1, 2, 7, 7, 2, 10, 10, 5};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine().trim());
        board = new int[n][n];

        for(int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int c = 0; c < n; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solve(n / 2, n / 2);
        bw.write(String.valueOf(result));
        bw.flush();
    }

    // 이동 -> 모래 뿌리기 -> 현재위치로 업데이트
    static int solve(int x, int y){
        int total = 0;
        int currentX = x;
        int currentY = y;

        while(true) {
            for(int d = 0; d < 4; d++) {
                for(int count = 0; count < dc[d]; count++){
                    //현재위치에서 이동
                    int nextX = currentX + dx[d];
                    int nextY = currentY + dy[d];

                    if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n){
                        return total;
                    }

                    //이동한 위치의 모래 뿌리기
                    int sand = board[nextX][nextY];
                    board[nextX][nextY] = 0;
                    int spt = 0;


                    for(int spread = 0; spread < 9; spread++) {
                        int sandX = nextX + dsx[d][spread];
                        int sandY = nextY + dsy[d][spread];
                        int spa = (sand * ratio[spread]) / 100;

                        if(sandX < 0 || sandX >= n || sandY < 0 || sandY >= n) {
                            total += spa;
                        }
                        else {
                            board[sandX][sandY] += spa;
                        }
                        spt += spa;
                    }

                    // 알파
                    int alphaX = nextX + dx[d];
                    int alphaY = nextY + dy[d];
                    int alphaAmount = sand - spt;
                    if(alphaX < 0 || alphaX >= n || alphaY < 0 || alphaY >= n) {
                        total += alphaAmount;
                    }
                    else {
                        board[alphaX][alphaY] += alphaAmount;
                    }

                    //이동한 위치를 현재위치로 업데이트
                    currentX = nextX;
                    currentY = nextY;
                }
            }

            // 횟수 업데이트
            for(int i = 0; i < 4; i++) {
                dc[i] +=2;
            }
        }
    }
}