package chap03.sec02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int suNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());
        long[] s = new long[suNo + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= suNo; i++) {
            s[i] = s[i - 1] + Integer.parseInt(st.nextToken());
        }

        for(int k = 0; k < quizNo; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(s[j] - s[i - 1]);
        }
    }
}
