package baekjoon.implementation;

import java.util.*;
import java.io.*;

public class Q14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if(!map.containsKey(key)) {
                map.put(key, value);
            } else {
                int v = map.get(key);
                if(v != value) {
                    count++;
                    map.put(key, value);
                }
            }
        }

        System.out.println(count);
    }
}