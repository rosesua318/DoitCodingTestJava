package chap11.sec01;

import java.util.Scanner;

public class P14501_퇴사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d[] = new int[n + 2]; // 오늘부터 퇴사일까지 벌 수 있는 최대 수입
        int t[] = new int[n + 1];
        int p[] = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        for(int i = n; i > 0; i--) {
            if(i + t[i] > n + 1) {
                d[i] = d[i + 1];
            } else {
                d[i] = Math.max(d[i + 1], p[i] + d[i + t[i]]);
            }
        }

        System.out.println(d[1]);
    }
}
