package chap07.sec01;

import java.util.Scanner;

public class P1016_제곱이아닌수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        // 최댓값과 최솟값의 차이마늠 배열 선언하기
        boolean[] check = new boolean[(int)(max - min + 1)];

        // 2의 제곱수인 4부터 max보다 작거나 같은 값까지 반복하기
        for(long i = 2; i * i <= max; i++) {
            long pow = i * i; // 제곱수
            long start_index = min / pow;
            if(min % pow != 0) {
                start_index++; // 나머지가 있으면 1을 더해야 min보다 큰 제곱수에서 시작됨
            }
            for(long j = start_index; pow * j <= max; j++) { // 제곱수를 true로 변경하기
                check[(int)((j * pow) - min)] = true;
            }
        }

        int count = 0;
        for(int i = 0; i <= max - min; i++) {
            if(!check[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
