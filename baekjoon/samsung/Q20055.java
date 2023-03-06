package baekjoon.samsung;

import java.io.*;
import java.util.*;

public class Q20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] belt = new int [2 * n][2]; // belt[][0]은 내구도, belt[][1]은 로붓 유무
        int[][] temp = new int [2 * n][2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * n; i++) {
            belt[i][0] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int count;
        while(true) {
            answer++;
            count = 0;
            // 한칸씩 이동시키기
            for(int i = 0; i < 2 * n; i++) {
                if(i == 0) {
                    for(int j = 0; j < 2; j++) {
                        temp[i][j] = belt[2 * n - 1][j];
                    }
                } else {
                    for(int j = 0; j < 2; j++) {
                        temp[i][j] = belt[i - 1][j];
                    }
                }
            }
            // temp값을 belt에 초기화
            for(int i = 0; i < 2 * n; i++) {
                for(int j = 0; j < 2; j++) {
                    belt[i][j] = temp[i][j];
                }
            }
            // 로봇이 내리는 위치에 닿는 경우 빼기
            if(belt[n - 1][1] == 1) {
                belt[n - 1][1] = 0;
            }
            // 로봇은 한칸 더 이동시키기
            for(int i = n - 2; i >= 1; i--) {
                if(belt[i][1] == 1 && belt[i + 1][1] != 1 && belt[i + 1][0] > 0) {
                    belt[i][1] = 0;
                    belt[i + 1][1] = 1;
                    belt[i + 1][0]--;
                }
            }
            // 이동한 로봇이 내리는 위치인 경우 빼기
            if(belt[n - 1][1] == 1) {
                belt[n - 1][1] = 0;
            }
            // 새로운 로봇 올리기
            if(belt[0][0] > 0) {
                belt[0][0]--;
                belt[0][1] = 1;
            }

            // 내구도 검사하기
            for(int i = 0; i < 2 * n; i++) {
                if(belt[i][0] <= 0) {
                    count++;
                }
            }
            if(count >= k) {
                break;
            }
        }
        System.out.println(answer);
    }
}