package chap10.sec01;

import java.io.IOException;
import java.util.Scanner;

public class P1256_사전 {
    static int n, m, k;
    static int[][] d;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        d = new int[202][202];
        for(int i = 0; i <= 200; i++) { // 조합 테이블 초기화
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    d[i][j] = 1;
                } else {
                    d[i][j] = d[i - 1][j - 1] + d[i - 1][j];
                    if(d[i][j] > 1000000000) {
                        d[i][j] = 1000000001; // k 범위가 넘어가면 범위의 최댓값 저장하기
                    }
                }
            }
        }
        if(d[n + m][m] < k) { // 주어진 자릿수로 만들 수 없는 k번째 수이면
            System.out.println("-1");
        } else {
            while(!(n == 0 && m == 0)) {
                // a를 선택했을 때 남은 문자로 만들 수 있는 경우의 수가 k보다 크면
                if(d[n - 1 + m][m] >= k) {
                    System.out.print("a");
                    n--;
                } else { // 모든 경우의 수가 k보다 작으면
                    System.out.print("z");
                    k = k - d[n - 1 + m][m]; // k값 업데이트
                    m--;
                }
            }
        }
    }
}
