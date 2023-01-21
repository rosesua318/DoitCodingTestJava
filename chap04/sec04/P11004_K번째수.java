package chap04.sec04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr, 0, n - 1, k - 1);
        System.out.println(arr[k - 1]);
    }

    public static void quickSort(int[] arr, int s, int e, int k) {
        if(s < e) {
            int pivot = partition(arr, s, e);
            if(pivot == k) { // k번째 수가 pivot이면 더이상 구할 필요 없음
                return;
            } else if(k < pivot) { // k가 pivot보다 작으면 왼쪽 구릅만 정렬 수행하기
                quickSort(arr, s, pivot - 1, k);
            } else { // k가 pivot보다 크면 오른쪽 그룹만 정렬 수행하기
                quickSort(arr, pivot + 1, e, k);
            }
        }
    }

    public static int partition(int[] arr, int s, int e) {
        if(s + 1 == e) {
            if(arr[s] > arr[e]) {
                swap(arr, s, e);
            }
            return e;
        }
        int m = (s + e) / 2;
        swap(arr, s, m); // 중앙값을 1번째 요소로 이동하기
        int pivot = arr[s];
        int i = s + 1, j = e;
        while(i <= j) {
            while(pivot < arr[j] && j > 0) { // 피벗보다 작은 수가 나올 때까지 j--
                j--;
            }
            while(pivot > arr[i] && i < arr.length - 1) { // 피벗보다 큰 수가 나올 때까지 i++
                i++;
            }
            if(i <= j) {
                swap(arr, i++, j--);
            }
        }

        // i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
        arr[s] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
