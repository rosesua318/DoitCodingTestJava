package chap03.sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_좋은수 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        long arr[] = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for(int k = 0; k < n; k++) {
            long find = arr[k];
            int i = 0;
            int j = n - 1;

            // 투 포인터 알고리즘
            while(i < j) {
                if(arr[i] + arr[j] == find) {
                    // find는 서로 다른 두 수의 합이어야 함을 체크
                    if(i != k && j != k) {
                        result++;
                        break;
                    } else if(i == k) {
                        i++;
                    } else if(j == k) {
                        j--;
                    }
                } else if(arr[i] + arr[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        System.out.println(result);
        br.close();
    }
}
