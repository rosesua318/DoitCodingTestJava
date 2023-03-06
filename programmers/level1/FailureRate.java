package programmers.level1;

import java.util.*;

public class FailureRate {
    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            Map<Integer,Double> map = new HashMap<>();

            for(int i = 1; i <= N; i++) {
                int stage = i;
                int noClear = 0;
                int current = 0;

                for(int j = 0; j < stages.length; j++) {
                    int player = stages[j];
                    // 현재 스테이지 클리어 못한 사람인 경우
                    if(stage == player) {
                        noClear++;
                    }
                    // 현재 스테이지 도전자인 경우
                    if(stage <= player) {
                        current++;
                    }
                }

                double frate = 0;
                if(noClear != 0 && current != 0) { // 스테이지에 도달한 유저가 있는 경우
                    frate = (double)noClear / (double)current;
                }
                map.put(stage, frate);
            }

            // value순으로 정렬하여 answer배열에 넣기
            for(int i = 0; i < N; i++) {
                double max = Integer.MIN_VALUE;
                int index = 0;
                for(Integer key : map.keySet()) {
                    if(max < map.get(key)) {
                        max = map.get(key);
                        index = key;
                    }
                }
                answer[i] = index;
                map.remove(index);
            }

            System.out.println(Arrays.toString(answer));
            return answer;
        }
    }
}

