package chap04.sec01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class mData implements Comparable<mData> {
    int value;
    int index;

    public mData(int value, int index) {
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) { // value 기준 오름차순 정렬
        return this.value - o.value;
    }
}

public class P1377_버블소트1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        mData[] arr = new mData[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr); // arr 배열 정렬(O(nlogn) 시간 복잡도)

        int max = 0;
        for(int i = 0; i < n; i++) {
            if(max < arr[i].index - i) { // 정렬 전 index - 정렬 후 index 계산의 최댓값 저장하기
                max = arr[i].index - i;
            }
        }

        System.out.println(max + 1); // swap이 일어나지 않는 반복문이 한 번 더 실행되는 것을 감안
    }
}
