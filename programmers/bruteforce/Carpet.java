package programmers.bruteforce;

public class Carpet {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            int n = brown + yellow;

            for (int i = 3; i < n; i++) {
                int j = n / i;
                if (n % i == 0 && j >= 3) {
                    int col = Math.max(i, j);
                    int row = Math.min(i, j);
                    int y = (col - 2) * (row - 2);
                    if (y == yellow) {
                        answer[0] = col;
                        answer[1] = row;
                        return answer;
                    }
                }
            }

            return answer;
        }
    }
}
