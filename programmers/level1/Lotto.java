package programmers.level1;

public class Lotto {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int zero = 0;
            int matched = 0;

            for(int n : lottos) {
                if(n == 0) {
                    zero++;
                } else {
                    for(int w : win_nums) {
                        if(n == w) {
                            matched++;
                            break;
                        }
                    }
                }
            }

            int min = matched;
            int max = matched + zero;

            int[] answer = { Math.min(7 - max, 6), Math.min(7 - min, 6) };
            return answer;
        }
    }
}
