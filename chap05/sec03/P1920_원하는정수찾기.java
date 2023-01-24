package chap05.sec03;

import java.util.Arrays;
import java.util.Scanner;

public class P1920_원하는정수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            boolean find = false;
            int target = sc.nextInt();
            // 이진 탐색 시작
            int start = 0;
            int end = arr.length - 1;
            while(start <= end) {
                int midi = (start + end) / 2;
                int midv = arr[midi];
                if(midv > target) {
                    end = midi - 1;
                } else if(midv < target) {
                    start = midi + 1;
                } else {
                    find = true;
                    break;
                }
            }

            if(find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
