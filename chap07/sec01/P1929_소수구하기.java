package chap07.sec01;

import java.util.Scanner;

public class P1929_소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[] = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for(int i = 2; i <= Math.sqrt(n); i++) { // 제곱근까지만 수행하기
            if(arr[i] == 0) {
                continue;
            }
            for(int j = i + i; j <= n; j = j + i) { // 배수 지우기
                arr[j] = 0;
            }
        }

        for(int i = m; i <= n; i++) {
            if(arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
