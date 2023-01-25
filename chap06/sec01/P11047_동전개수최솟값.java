package chap06.sec01;

import java.util.Scanner;

public class P11047_동전개수최솟값 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(arr[i] <= k) { // 현재 동전의 가치가 K보다 작거나 같으면 구성에 추가
                count += (k / arr[i]);
                k %= arr[i]; // K를 현재 동전을 사용하고 남은 금액으로 갱신
            }
        }

        System.out.println(count);
    }
}
