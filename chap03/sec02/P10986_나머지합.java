package chap03.sec02;

import java.util.Scanner;

public class P10986_나머지합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] s = new long[n];
        long[] c = new long[m];
        long answer = 0;
        s[0] = sc.nextInt();
        for(int i = 1; i < n; i++) {
            // 수열 합 배열 만들기
            s[i] = s[i - 1] + sc.nextInt();
        }

        // 합 배열의 모든 값에 % 연산 수행하기
        for(int i = 0; i < n; i++) {
            int remainder = (int)(s[i] % m);

            // 0~i까지의 구간 합 자체가 0일 때 정답에 더하기
            if(remainder == 0) {
                answer++;
            }

            // 나머지가 같은 인덱스의 개수 카운팅하기
            c[remainder]++;
        }

        for(int i = 0; i < m; i++) {
            if(c[i] > 1) {
                // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
                answer += (c[i] * (c[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}
