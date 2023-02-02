package chap08.sec06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11403_경로찾기 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int distance[][];
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        distance = new int[n][n];
        for(int i = 0; i < n; i++) { // 입력되는 인접 행렬의 값을 그대로 저장하기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());
                distance[i][j] = v;
            }
        }

        // 변형된 플로이드-워셜 알고리즘 수행하기
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(distance[i][k] == 1 && distance[k][j] == 1) {
                        distance[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}
