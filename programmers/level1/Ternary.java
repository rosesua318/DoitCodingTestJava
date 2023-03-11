package programmers.level1;

public class Ternary {
    class Solution {
        public int solution(int n) {
            String str = "";
            while(n != 0) {
                str += n % 3;
                n /= 3;
            }
            return Integer.parseInt(str, 3);
        }
    }
}
