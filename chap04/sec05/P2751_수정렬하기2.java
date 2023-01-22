package chap04.sec05;

import java.io.*;

public class P2751_수정렬하기2 {
    public static int[] arr, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        tmp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        merge_sort(1, n); // 병합 정렬 수행하기
        for(int i = 1; i <= n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    private static void merge_sort(int s, int e) {
        if(e - s < 1) {
            return;
        }
        int m = s + (e - s) / 2;
        // 재귀 함수 형태로 구현
        merge_sort(s, m);
        merge_sort(m + 1, e);
        for(int i = s; i <= e; i++) {
            tmp[i] = arr[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while(index1 <= m && index2 <= e) { // 두 그룹을 병합하는 로직
            // 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고, 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동하기
            if(tmp[index1] > tmp[index2]) {
                arr[k] = tmp[index2];
                k++;
                index2++;
            } else {
                arr[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while(index1 <= m) { // 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리하기
            arr[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= e) {
            arr[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
