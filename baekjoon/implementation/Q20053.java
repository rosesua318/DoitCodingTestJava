package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class Q20053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num > max) {
                    max = num;
                }
                if(min > num) {
                    min = num;
                }
            }
            System.out.println(min + " " + max);
        }

    }
}