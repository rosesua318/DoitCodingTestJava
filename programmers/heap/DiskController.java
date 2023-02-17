package programmers.heap;

import java.util.*;

public class DiskController {
    class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            int end = 0; // 수행되고난 직후의 시간
            int index = 0; // jobs 배열 인덱스
            int count = 0; // 수행된 작업 갯수

            // jobs 배열 오름차순 정렬 (요청시간 기준으로 오름차순)
            Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
            // 처리 시간 기준으로 오름차순 정렬되는 우선순위 큐
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

            while(count < jobs.length) {
                // 하나의 작업이 완료되는 시점까지 들어온 요청들을 큐에 넣기
                while(index < jobs.length && jobs[index][0] <= end) {
                    pq.add(jobs[index++]);
                }

                if (pq.isEmpty()) {
                    end = jobs[index][0]; // 작업 완료 이후에 요청 다시 받기 위해

                } else { // 작업 끝나기 전 들어온 요청 중에 수행시간이 가장 짧은 요청부터 수행
                    int[] temp = pq.poll();
                    answer += temp[1] + end - temp[0];
                    end += temp[1];
                    count++;
                }
            }

            return (int) Math.floor(answer / jobs.length);
        }
    }
}
