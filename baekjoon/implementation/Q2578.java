package baekjoon.implementation;

import java.util.Scanner;

public class Q2578 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int arr[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n * n; i++) {
            int count = 0;
            int temp = sc.nextInt();
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(arr[j][k] == temp) {
                        arr[j][k]=0;
                    }
                }
            }
            for(int j = 0; j < n; j++) {
                if(arr[j][0] == 0) {
                    int sum = 0;
                    for (int k = 0; k < n; k++) {
                        sum += arr[j][k];
                    }
                    if(sum == 0) {
                        count++;
                    }
                }
                if(arr[0][j] == 0) {
                    int sum = 0;
                    for(int k = 0; k < n; k++) {
                        sum += arr[k][j];
                    }
                    if(sum == 0) {
                        count++;
                    }
                }
            }
            if(arr[0][0] == 0) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += arr[k][k];
                }
                if(sum == 0) {
                    count++;
                }

            }
            if(arr[n - 1][0] == 0) {
                int sum = 0;
                for(int k = 0; k < n; k++) {
                    sum += arr[n - k - 1][k];
                }
                if(sum == 0) {
                    count++;
                }

            }
            if(count >= 3) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}