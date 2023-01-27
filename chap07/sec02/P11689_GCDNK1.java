package chap07.sec02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11689_GCDNK1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = n;
        for(long p = 2; p <= Math.sqrt(n); p++) { // 제곱근까지만 진행하기
            if(n % p == 0) { // p가 소인수인지 확인하기
                result = result - result / p; //결괏값 업데이트하기
                while(n % p == 0) {
                    n /= p;
                }
            }
        }

        if(n > 1) { // 아직 소인수 구성이 남아 있을 때
            // 반복문에서 제곱근까지만 탐색했으므로 1개의 소인수가 누락되는 케이스
            result = result - result / n;
        }
        System.out.println(result);
    }
}
