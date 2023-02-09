package chap10.sec01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1772_순열의순서 {
    public static void main(String[] args) throws IOException {
        int n, q;
        long f[] = new long[21];
        int s[] = new int[21];
        boolean visited[] = new boolean[21];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        q = Integer.parseInt(st.nextToken());
        f[0] = 1;
        for(int i = 1; i <= n; i++) { // 팩토리얼 초기화 -> 각 자리수에서 만들 수 있는 경우의 수
            f[i] = f[i - 1] * i;
        }
        if(q == 1) {
            long k = Long.parseLong(st.nextToken());
            for(int i = 1; i <= n; i++) {
                for(int j = 1, cnt = 1; j <= n; j++) {
                    if(visited[j]) {
                        continue; // 이미 사용한 숫자는 사용할 수 없음
                    }
                    if(k <= cnt * f[n - i]) { // 주어진 k에 따라 각 자리에 들어갈 수 있는 수 찾기
                        k -= ((cnt - 1) * f[n - i]);
                        s[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for(int i = 1; i <= n; i++) {
                System.out.print(s[i] + " ");
            }
        } else {
            long k = 1;
            for(int i = 1; i <= n; i++) {
                s[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for(int j = 1; j < s[i]; j++) {
                    if(visited[j] == false) {
                        cnt++; // 미사용 숫자 개수만큼 카운트
                    }
                }
                k += cnt * f[n - i]; // 자릿수에 따라 순서 더하기
                visited[s[i]] = true;
            }
            System.out.println(k);
        }
    }
}
