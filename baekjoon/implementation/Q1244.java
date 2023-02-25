package baekjoon.implementation;

import java.util.Scanner;

public class Q1244 {
    static int n, t;
    static int[] switches;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        switches = new int[n];
        for(int i = 0; i < n; i++) {
            switches[i] = sc.nextInt();
        }
        t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int gender = sc.nextInt();
            int number = sc.nextInt();
            if(gender == 1) {
                for(int j = (number - 1); j < n; j += number) {
                    switches[j] = (switches[j] == 0) ? 1 : 0;
                }
            } else {
                switches[number - 1] = (switches[number - 1] == 0) ? 1 : 0;
                for (int j = 1; (number - 1) - j >= 0 && j + (number - 1) < n; j++) {
                    if (switches[(number - 1) - j] == switches[(number - 1) + j]) {
                        switches[(number - 1) - j] = (switches[(number - 1) - j] == 0) ? 1 : 0;
                        switches[(number - 1) + j] = (switches[(number - 1) + j] == 0) ? 1 : 0;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < switches.length; i++) {
            System.out.print(switches[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}