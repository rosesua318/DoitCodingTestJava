package programmers.level2;

public class NextBigNumber {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int nc = Integer.bitCount(n);
            int tc = 0;

            while(true) {
                n++;
                tc = Integer.bitCount(n);
                if(nc == tc) {
                    answer = n;
                    break;
                }
            }

            return answer;
        }
    }
}
