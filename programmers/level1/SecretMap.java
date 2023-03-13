package programmers.level1;

public class SecretMap {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            for(int i = 0; i < n; i++) {
                String str = Integer.toBinaryString(arr1[i] | arr2[i]); // 이진수로 바꾼 후 OR비트논리연산
                str = String.format("%" + n + "s", str);  // 5자리 문자열 형태로 바꾸기
                str = str.replaceAll("1" , "#"); // 1을 #으로 바꾸기
                str = str.replaceAll("0" , " "); // 0을 공백으로 바꾸기
                answer[i] = str;
            }
            return answer;
        }
    }
}
