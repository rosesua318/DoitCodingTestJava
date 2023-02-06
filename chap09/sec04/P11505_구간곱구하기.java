package chap09.sec04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11505_구간곱구하기 {
    static long[] tree;
    static int mod;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 변경이 일어나는 횟수
        int k = Integer.parseInt(st.nextToken()); // 구간 합을 구하는 횟수
        int treeHeight = 0;
        int lenght = n;
        while(lenght != 0) {
            lenght /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leftNodeStartIndex = treeSize / 2 - 1;
        mod = 1000000007;
        tree = new long[treeSize + 1];
        for(int i = 0; i < tree.length; i++) { // 곱셈이므로 초깃값을 1로 설정
            tree[i] = 1;
        }
        // 데이터를 리프 노드에 입력받기
        for(int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1); // tree 만들기
        for(int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if(a == 1) { // 변경
                changeVal(leftNodeStartIndex + s, e);
            } else if(a == 2) { // 구간 합
                s += leftNodeStartIndex;
                e += leftNodeStartIndex;
                System.out.println(getMul(s, (int) e));
            } else {
                return;
            }
        }
        br.close();
    }

    // 초기 트리를 구성하는 함수
    private static void setTree(int i) {
        while(i != 1) {
            tree[i / 2] = tree[i / 2] * tree[i] % mod;
            i--;
        }
    }

    // 값을 변경하는 함수
    private static void changeVal(int index, long val) {
        tree[index] = val;
        while(index > 1) { // 현재 노드의 양쪽 자식 노드를 찾아 곱하는 로직
            index /= 2;
            tree[index] = tree[index * 2] % mod * tree[index * 2 + 1] % mod;
        }
    }

    // 모든 함수에서 곱셈이 발생할 때마다 mod 연산 수행하기
    private static long getMul(int s, int e) {
        long partMul = 1;
        while(s <= e) {
            if(s % 2 == 1) {
                partMul = partMul * tree[s] % mod;
                s++;
            }
            if(e % 2 == 0) {
                partMul = partMul * tree[e] % mod;
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return partMul;
    }
}
