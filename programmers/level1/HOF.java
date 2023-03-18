package programmers.level1;

import java.util.*;

public class HOF {
    class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            ArrayList<Integer> arr = new ArrayList();
            for(int i = 0; i < score.length; i++) {
                if(i < k - 1) {
                    arr.add(score[i]);
                    arr.sort(Collections.reverseOrder());
                    answer[i] = arr.get(arr.size() - 1);
                } else if(i >= k - 1) {
                    arr.add(score[i]);
                    arr.sort(Collections.reverseOrder());
                    answer[i] = arr.get(k - 1);
                }
            }
            return answer;
        }
    }
}
