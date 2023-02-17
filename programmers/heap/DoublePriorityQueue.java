package programmers.heap;

import java.util.*;

public class DoublePriorityQueue {
    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];
            PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙
            PriorityQueue<Integer> mpq = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙

            for(String s : operations) {
                StringTokenizer st = new StringTokenizer(s);
                String op = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                //빈 큐에 데이터를 삭제 요청할 경우 연산 무시
                if (pq.size() < 1 && op.equals("D")) {
                    continue;
                }

                //삽입 시 최소 힙, 최대 힙에 value 넣기
                if (op.equals("I")) {
                    pq.offer(value);
                    mpq.offer(value);
                    continue;
                }

                // value값이 0보다 작은 경우 최소 힙에서 poll한 후 최대 힙에서 해당 원소 삭제
                if(value < 0) {
                    mpq.remove(pq.poll());
                    continue;
                }
                pq.remove(mpq.poll());
            }

            if(pq.size() > 0 ) {
                answer[0] = mpq.poll();
                answer[1] = pq.poll();
            }

            return answer;
        }
    }
}
