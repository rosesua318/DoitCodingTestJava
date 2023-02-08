package chap10.sec01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13251_조약돌꺼내기 {
    public static void main(String[] args) throws IOException {
        int m, k, t;
        int d[] = new int[51];
        double probability[] = new double[51];
        double ans;
        t = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            d[i] = Integer.parseInt(st.nextToken());
            t += d[i];
        }
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        ans = 0.0;
        for(int i = 0; i < m; i++) {
            if(d[i] >= k) {
                probability[i] = 1.0;
                for(int l = 0; l < k; l++) {
                    probability[i] *= (double) (d[i] - l) / (t - l);
                }
            }
            ans += probability[i];
        }

        System.out.println(ans);
    }
}
