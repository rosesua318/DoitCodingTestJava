package chap07.sec03;

import java.util.Scanner;

public class P1934_최소공배수 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = a * b / gcd(a, b);
            System.out.println(result);
        }
    }

    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a % b); // 재귀 함수의 형태로 구현
        }
    }
}
