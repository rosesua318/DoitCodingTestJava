package programmers.stack_queue;

import java.util.*;

public class FeatureDevelop {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < speeds.length; i++) {
                double remain = (100 - progresses[i]) / (double) speeds[i];
                int date = (int) Math.ceil(remain); // 작업의 남은 일수

                if (!queue.isEmpty() && queue.peek() < date) { // 현재 작업의 남은 일수가 큐에 있는 작업의 남은 일수 보다 클 때
                    list.add(queue.size()); // 큐 사이즈(작업의 개수)를 배포 개수 리스트에 추가
                    queue.clear(); // 큐 비우기
                }

                queue.offer(date); // 현재 작업의 남은 일수를 큐에 추가
            }

            list.add(queue.size()); // 남아있는 작업의 개수 추가시키기

            int[] answer = new int[list.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i); // 정답 배열에 추가
            }

            return answer;
        }
    }

    public static void main(String[] args) {

    }
}
