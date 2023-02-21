package programmers.greedy;

import java.util.*;

public class GymSuit {
    class Solution {
        public int solution(int n, int[] lost, int[] reverse) {
            int answer = n - lost.length;

            Arrays.sort(lost);
            Arrays.sort(reverse);

            // 여벌이 있는 학생이 체육복을 도난 당한 경우
            for(int i = 0; i < lost.length; i++) {
                for(int j = 0; j < reverse.length; j++) {
                    if(lost[i] == reverse[j]) { // 자기 자신일 경우
                        answer++; // 여벌의 자기 옷 입으면 되므로 참여자 수 증가
                        lost[i] = -1;
                        reverse[j] = -1;
                        break;
                    }
                }
            }

            // 다른 사람에게 체육복을 빌려주는 경우
            for(int i = 0; i < lost.length; i++) {
                for(int j = 0; j < reverse.length; j++) {
                    // 도난당한 사람보다 1 작거나 1 큰경우만 가능
                    if((lost[i] - 1 == reverse[j]) || (lost[i] + 1 == reverse[j])) {
                        answer++;
                        reverse[j] = -1;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
