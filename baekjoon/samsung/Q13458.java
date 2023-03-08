package baekjoon.samsung;

import java.io.*;
import java.util.*;

public class Q13458 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rooms = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            rooms[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long count = 0;
        for(int i = 0; i < n; i++) {
            count++;
            rooms[i] -= b;
            if(rooms[i] > 0) {
                count += (rooms[i]) / c;
                if(rooms[i] % c > 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}