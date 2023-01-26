package chap06.sec01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1931_회의실배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) { // 종료 시간이 같을 때
                    return o1[0] - o2[0]; // 시작 시간 기준으로 오름차순 정렬
                }
                return o1[1] - o2[1]; // 종료 시간 기준으로 오름차순 정렬
            }
        });

        int count = 0;
        int end = -1;
        for(int i = 0; i < n; i++) {
            if(arr[i][0] >= end) { // 겹치지 않는 다음 회의가 나온 경우
                end = arr[i][1]; // 종료 시간 업데이트하기
                count++;
            }
        }

        System.out.println(count);
    }
}
