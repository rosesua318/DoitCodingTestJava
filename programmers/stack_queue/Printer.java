package programmers.stack_queue;

import java.util.*;

public class Printer {
    class Solution {
        public int solution(int[] priorities, int location) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 중요도가 높은 순으로 저장됨
            int answer = 0;

            for (int i = 0; i < priorities.length; i++) {
                pq.add(priorities[i]);
            }

            while (!pq.isEmpty()) {
                for (int i = 0; i < priorities.length; i++) {
                    if (priorities[i] == pq.peek()) {
                        if (i == location) {
                            answer++;
                            return answer;
                        }
                        pq.poll();
                        answer++;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {

    }
}
