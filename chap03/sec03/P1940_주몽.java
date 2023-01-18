package chap03.sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int count = 0;
        int i = 0;
        int j = n - 1;
        while(i < j) { // 투 포인터 이동 원칙 따라 포인터를 이동하며 처리
            if(arr[i] + arr[j] < m) {
                i++;
            } else if(arr[i] + arr[j] > m) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);
        br.close();
    }
}
