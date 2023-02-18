package programmers.sort;

import java.util.*;

public class LargestNumber {
    class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            String[] str = new String[numbers.length];

            for(int i = 0; i < numbers.length; i++){
                str[i] = String.valueOf(numbers[i]);
            }

            //내림차순 정렬
            Arrays.sort(str, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2 + o1).compareTo(o1 + o2);
                }
            });

            // 답이 000~이 되면 안되기 때문에 첫번째값이 0이면 0을 리턴
            if (str[0].equals("0")) {
                return "0";
            }

            for(String s: str) {
                answer += s;
            }

            return answer;
        }
    }
}
