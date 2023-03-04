package programmers.level1;

public class Decimal {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            boolean flag = false;

            for(int i = 0; i < nums.length; i++) {
                for(int j = i + 1; j < nums.length; j++) {
                    for(int k = j + 1; k < nums.length; k++) {
                        int num = nums[i] + nums[j] + nums[k];
                        if(num >= 2) {
                            flag = function(num);
                        }
                        if(flag) { // 소수일 경우
                            answer++;
                        }
                    }
                }

            }
            return answer;
        }

        public boolean function(int num) {
            boolean flag = true;
            if(num == 2) {
                return flag;

            }
            for(int i = 2; i < num; i++) {
                if(num % i == 0) { // 소수가 아닌 경우
                    flag = false;
                    break;
                }
            }
            return flag;
        }
    }
}
