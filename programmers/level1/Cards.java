package programmers.level1;

public class Cards {
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "Yes";
            int one = 0;
            int two = 0;

            for(int i = 0; i < goal.length; i++) {
                if(one < cards1.length && goal[i].equals(cards1[one])) {
                    one++;
                } else if(two < cards2.length && goal[i].equals(cards2[two])) {
                    two++;
                } else {
                    answer = "No";
                    break;
                }
            }

            return answer;
        }
    }
}
