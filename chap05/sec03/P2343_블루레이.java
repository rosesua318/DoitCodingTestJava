package chap05.sec03;

import java.util.Scanner;

public class P2343_블루레이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        int start = 0;
        int end = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(start < arr[i]) {
                start = arr[i]; // 레슨 최댓값을 시작 인덱스로 저장하기
            }
            end += arr[i]; // 모든 레슨의 총합을 종료 인덱스로 저장하기
        }

        while(start <= end) {
            int middle = (start + end) / 2;
            int sum = 0;
            int count = 0;
            for(int i = 0; i < n; i++) { // middle 값으로 모든 레슨을 저장할 수 있는지 확인
                if(sum + arr[i] > middle) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if(sum != 0) { // 탐색 후 sum이 0이 아니면 블루레이가 1개 더 필요하므로 더함
                count++;
            }
            if(count > m) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        System.out.println(start);
    }
}
