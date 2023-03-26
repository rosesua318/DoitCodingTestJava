package programmers.level1;

public class SecretPassword {
    class Solution {
        public String solution(String s, String skip, int index) {
            char[] arr = s.toCharArray();
            for(int i = 0 ; i < arr.length ; i++){
                for(int j = 0 ; j < index ; j++){
                    do {
                        arr[i]++;
                        if(arr[i] > 'z'){
                            arr[i] -= 26; // 'a'와 동일
                        }
                    } while(skip.contains(String.valueOf(arr[i])));
                }
            }
            return String.valueOf(arr);
        }
    }
}
