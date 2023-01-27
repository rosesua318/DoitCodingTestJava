package chap07.sec01;

import java.util.Scanner;

public class P1747_소수팰린드롬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[10000001]; // n의 범위까지 소수 구하기
        for(int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for(int i = 2; i < Math.sqrt(arr.length); i++) { // 제곱근까지만 수행하기
            if(arr[i] == 0) {
                continue;
            }
            for(int j = i + i; j < arr.length; j = j + i) { // 배수 지우기
                arr[j] = 0;
            }
        }

        int i = n;
        while(true) { // n부터 1씩 증가시키면서 소수와 팰린드롬 수가 맞는지 확인하기
            if(arr[i] != 0) {
                int result = arr[i];
                if(isPalindrome(result)) {
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean isPalindrome(int target) { // 펠린드롬 수 판별 함수
        char temp[] = String.valueOf(target).toCharArray();
        int s = 0;
        int e = temp.length - 1;
        while(s < e) {
            if(temp[s] != temp[e])
                return false;
            s++;
            e--;
        }
        return true;
    }
}
