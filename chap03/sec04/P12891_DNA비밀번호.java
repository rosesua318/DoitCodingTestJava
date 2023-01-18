package chap03.sec04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {
    static int checkArr[];
    static int myArr[];
    static int checkSecret;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int result = 0;
        char arr[] = new char[s];
        checkArr= new int[4];
        myArr = new int[4];
        checkSecret = 0;
        arr = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0) {
                checkSecret++;
            }
        }
        for(int i = 0; i < p; i++) {
            // 초기 p 부분 문자열 처리 부분
            Add(arr[i]);
        }
        if(checkSecret == 4) {
            result++;
        }

        // 슬라이딩 윈도우 처리 부분
        for(int i = p; i < s; i++) {
            int j = i - p;
            Add(arr[i]);
            Remove(arr[j]);
            if(checkSecret == 4) { // 4자릿수와 관련된 크기가 모두 충족될 때 유효한 비밀번호
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }

    // 새로 들어온 문자를 처리하는 함수
    private static void Add(char c) {
        switch(c) {
            case 'A' :
                myArr[0]++;
                if(myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C' :
                myArr[1]++;
                if(myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case 'G' :
                myArr[2]++;
                if(myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;
            case 'T' :
                myArr[3]++;
                if(myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }

    // 제거되는 문자를 처리하는 함수
    private static void Remove(char c) {
        switch(c) {
            case 'A' :
                if(myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C' :
                if(myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G' :
                if(myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T' :
                if(myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
}
