package chap04.sec06;

import java.io.*;

public class P10989_수정렬하기3 {
    public static int[] arr;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        radix_sort(arr, 5);
        for(int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void radix_sort(int[] arr, int max_size) {
        int[] output = new int[arr.length];
        int jarisu = 1;
        int count = 0;
        while(count != max_size) { // 최대 자릿수만큼 반복하기
            int[] bucket = new int[10];
            for(int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / jarisu) % 10]++; // 일의 자리수부터 시작하기
            }
            for(int i = 1; i < 10; i++) { // 합 배열을 이용해 index 계산하기
                bucket[i] += bucket[i - 1];
            }
            for(int i = arr.length - 1; i >= 0; i--) { // 현재 자릿수를 기준으로 정렬하기
                output[bucket[(arr[i] / jarisu % 10)] - 1] = arr[i];
                bucket[(arr[i] / jarisu) % 10]--;
            }
            for(int i = 0; i < arr.length; i++) {
                // 다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장하기
                arr[i] = output[i];
            }
            jarisu = jarisu * 10; // 자릿수 증가시키기
            count++;
        }
    }
}
