package chap08.sec06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1389_케빈베이컨의6단계법칙 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int distance[][];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        distance = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) { // 인접 행렬 초기화하기
            for(int j = 1; j <= n; j++) {
                if(i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 10000001; // 충분히 큰 수로 저장하기
                }
            }
        }
        for(int i = 0; i < m; i++) { // 친구 관계이므로 양방향 저장을 하며 1로 가중치 통일
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            distance[s][e] = 1;
            distance[e][s] = 1;
        }

        // 플로이드-워셜 알고리즘 수행하기
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int answer = -1;
        for(int i = 1; i <= n; i++) {
            int temp = 0;
            for(int j = 1; j <= n; j++) {
                temp += distance[i][j];
            }
            if(min > temp) { // 가장 작은 케빈 베이컨의 수를 지니고 있는 i를 찾기
                min = temp;
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
