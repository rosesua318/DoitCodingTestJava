package chap03.sec03;

import java.util.Scanner;

public class P2018_연속된자연수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while(end_index != n) {
            if(sum == n) { // 현재 연속 합이 n과 같은 경우
                count++;
                end_index++;
                sum += end_index;
            } else if(sum > n) { // 현재 연속 합이 n보다 더 큰 경우
                sum -= start_index;
                start_index++;
            } else { // 현재 연속 합이 n보다 작은 경우
                end_index++;
                sum += end_index;
            }
        }

        System.out.println(count);
    }
}
