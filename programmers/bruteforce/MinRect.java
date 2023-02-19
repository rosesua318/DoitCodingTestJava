package programmers.bruteforce;

public class MinRect {
    class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;
            int mv = 0;
            int mh = 0;
            for(int i = 0; i < sizes.length; i++) {
                int v = Math.max(sizes[i][0],sizes[i][1]);
                int h = Math.min(sizes[i][0],sizes[i][1]);
                mv = Math.max(mv, v);
                mh = Math.max(mh, h);
            }
            return answer = mv * mh;
        }
    }
}
