package baekjoon.bruteforce;

import java.io.*;

public class Q2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (sum(i) == n) { // 분해합이 n과 같으면 i는 n의 생성자가 된다
                answer = i;
                break;
            }
        }
        System.out.print(answer);
    }

    //분해합 구하는 함수
    static int sum(int n) {
        int ans = n;
        while(n != 0) {
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
}