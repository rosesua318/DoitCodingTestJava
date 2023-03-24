package programmers.level1;

public class SplitString {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            char c = s.charAt(0);
            int num = 0;
            int diff = 0;

            for(int i = 0; i < s.length(); i++) {
                if(num == diff) {
                    answer++;
                    c = s.charAt(i);
                }
                if(s.charAt(i) == c) {
                    num++;
                }
                else {
                    diff++;
                }
            }

            return answer;
        }
    }
}
