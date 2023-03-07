package baekjoon.samsung;

import java.io.*;
import java.util.*;

public class Q12100 {
    static int answer;
    static int[][] matrix;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int count) {
        if(count == 5) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    answer = Math.max(answer, matrix[i][j]);
                }
            }
        } else {
            int[][] temp = new int[n][n];
            for(int i = 0; i < n; i++) {
                temp[i] = matrix[i].clone();
            }
            for(int i = 0; i < 4; i++) {
                if(i == 0) { // 위로 몰기
                    for(int j = 0; j < n; j++) {
                        int index = 0;
                        int block = 0;
                        for(int k = 0; k < n; k++) {
                            if(matrix[k][j] != 0) {
                                if(block == matrix[k][j]) {
                                    matrix[index - 1][j] = block * 2;
                                    block = 0;
                                    matrix[k][j] = 0;
                                } else {
                                    block = matrix[k][j];
                                    matrix[k][j] = 0;
                                    matrix[index][j] = block;
                                    index++;
                                }
                            }
                        }
                    }
                } else if(i == 1) { // 왼쪽으로 몰기
                    for(int j = 0; j < n; j++) {
                        int index = n - 1;
                        int block = 0;
                        for(int k = n - 1; k >= 0; k--) {
                            if(matrix[k][j] != 0) {
                                if(block == matrix[k][j]) {
                                    matrix[index + 1][j] = block * 2;
                                    block = 0;
                                    matrix[k][j] = 0;
                                } else {
                                    block = matrix[k][j];
                                    matrix[k][j] = 0;
                                    matrix[index][j] = block;
                                    index--;
                                }
                            }
                        }
                    }
                } else if(i == 2) { // 아래로 몰기
                    for(int j = 0; j < n; j++) {
                        int index = 0;
                        int block = 0;
                        for(int k = 0; k < n; k++) {
                            if(matrix[j][k] != 0) {
                                if(block == matrix[j][k]) {
                                    matrix[j][index - 1] = block * 2;
                                    block = 0;
                                    matrix[j][k] = 0;
                                } else {
                                    block = matrix[j][k];
                                    matrix[j][k] = 0;
                                    matrix[j][index] = block;
                                    index++;
                                }
                            }
                        }
                    }
                } else if(i == 3) { // 오른쪽으로 몰기
                    for(int j = 0; j < n; j++) {
                        int index = n - 1;
                        int block = 0;
                        for(int k = n - 1; k >= 0; k--) {
                            if(matrix[j][k] != 0) {
                                if(block == matrix[j][k]) {
                                    matrix[j][index + 1] = block * 2;
                                    block = 0;
                                    matrix[j][k] = 0;
                                } else {
                                    block = matrix[j][k];
                                    matrix[j][k] = 0;
                                    matrix[j][index] = block;
                                    index--;
                                }
                            }
                        }
                    }
                }
                dfs(count + 1);
                for(int j = 0; j < n; j++) {
                    matrix[j] = temp[j].clone();
                }
            }
        }
    }
}