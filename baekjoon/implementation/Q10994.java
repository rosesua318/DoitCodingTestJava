package baekjoon.implementation;

import java.util.*;

public class Q10994 {
    static char star[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 1;
        for(int i = 1; i < n; i++) {
            m += 4;
        }
        star = new char[m][m];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                star[i][j] = ' ';
            }
        }

        draw(0, m);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
    }

    public static void draw(int s, int m) {
        for(int i = s; i < m; i++) {
            star[s][i] = '*'; // 맨 위 가로줄
            star[m - 1][i] = '*'; // 맨 아래 가로줄
            star[i][s] = '*'; // 왼쪽 세로줄
            star[i][m - 1] = '*'; // 오른쪽 세로줄
        }

        if(m == 1) {
            return;
        }

        draw(s + 2, m - 2);
    }
}