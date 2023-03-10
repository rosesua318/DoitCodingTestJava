package programmers.level1;

public class Keypad {
    class Solution {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            int left =10; // '*' => 10으로 치환
            int right =12; // '#' => 12로 치환

            for(int number : numbers) {
                if(number == 1 || number == 4 || number == 7) {
                    answer += "L";
                    left = number;
                } else if(number == 3 || number == 6 || number == 9) {
                    answer += "R";
                    right = number;
                } else {
                    if(number == 0) {
                        number = 11;
                    }
                    int ldist = Math.abs(number - left) / 3 + Math.abs(number - left) % 3;
                    int rdist = Math.abs(number - right) / 3 + Math.abs(number - right) % 3;
                    if(ldist < rdist) {
                        answer += "L";
                        left = number;
                    } else if(ldist > rdist) {
                        answer += "R";
                        right = number;
                    } else {
                        if(hand.equals("left")) {
                            answer += "L";
                            left = number;
                        } else {
                            answer += "R";
                            right = number;
                        }
                    }
                }
            }

            return answer;
        }
    }
}
