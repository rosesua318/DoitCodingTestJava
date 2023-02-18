package baekjoon.bruteforce;

import java.util.*;
import java.io.*;

public class Q22864 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sum = 0;
        int current = 0; // 현재 피로도
        for(int i = 0; i < 24; i++) { // 24시간
            if(current + a <= m) { // 현재 피로도에 a를 더해도 m이하일 경우
                sum += b; // 일하기
                current += a; // 피로도 a만큼 더해짐
            } else { // 일을 하면 피로도가 m을 넘을 때
                current -= c; // 휴식을 취함
                if (current < 0) { // 현재 피로도가 음수일 경우 0으로 바꿔줌
                    current = 0;
                }
            }
        }
        System.out.print(sum);
    }
}