package programmers.level1;

public class Substring {
    class Solution {
        public int solution(String t, String p) {
            int answer = 0;
            int length = t.length() - p.length() + 1;

            for(int i = 0; i < length; i++) {
                if(Long.parseLong(p) >= Long.parseLong(t.substring(i, i + p.length()))) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
