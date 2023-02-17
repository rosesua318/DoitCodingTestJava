package programmers.heap;

import java.util.*;

public class Scoville {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue();

            for (int n : scoville) {
                pq.offer(n);
            }

            while (!pq.isEmpty()) {
                int current = pq.poll();
                if (current < K) {
                    if (pq.size() == 0) { // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없음
                        return -1;
                    }
                    int next = pq.poll();
                    int sum = current + next * 2;
                    pq.offer(sum);
                    answer++;
                }
            }

            return answer;
        }
    }
    public static void main(String[] args) {

    }
}
