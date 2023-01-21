package chap04.sec03;

import java.util.Scanner;

public class P11339_ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int s[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 삽입 정렬
        for(int i = 1; i < n; i++) {
            int insert_point = i;
            int insert_value = arr[i];
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i]) {
                    insert_point = j + 1;
                    break;
                }
                if(j == 0) {
                    insert_point = 0;
                }
            }
            for(int j = i; j > insert_point; j--) {
                arr[j] = arr[j - 1];
            }
            arr[insert_point] = insert_value;
        }

        s[0] = arr[0]; // 합 배열 만들기
        for(int i = 1; i < n; i++) {
            s[i] = s[i - 1] + arr[i];
        }
        int sum = 0; // 합 배열 총합 구하기
        for(int i = 0; i < n; i++) {
            sum += s[i];
        }

        System.out.println(sum);
    }
}
