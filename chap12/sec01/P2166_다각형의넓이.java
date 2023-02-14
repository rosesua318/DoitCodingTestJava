package chap12.sec01;

import java.util.Scanner;

public class P2166_다각형의넓이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] x = new long[n + 1];
        long[] y = new long[n + 1];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        x[n] = x[0]; // 마지막과 처음점도 CCW 계산에 포함해주어야함
        y[n] = y[0];
        double result = 0;
        for (int i = 0; i < n; i++) {
            result += (x[i] * y[i + 1]) - (x[i + 1] * y[i]);
        }
        String answer = String.format("%.1f", Math.abs(result) / 2.0); // 둘째 자리 반올림
        System.out.println(answer);
    }
}