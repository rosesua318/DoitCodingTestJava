package programmers.level2;

import java.util.*;

public class MaxMin {
    class Solution {
        public String solution(String s) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            String[] str = s.split(" ");

            for(int i = 0; i < str.length; i++) {
                arr.add(Integer.parseInt(str[i]));
            }

            return String.valueOf(Collections.min(arr)) + " " + String.valueOf(Collections.max(arr));
        }
    }
}
