package programmers.level1;

public class DartGame {
    class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            int[] game = new int[3];
            int n = 0;
            int index = 0;
            String str = "";

            for(char c : dartResult.toCharArray()) {
                if(Character.isDigit(c)) {
                    str += String.valueOf(c);
                } else if(c == 'S' || c == 'D' || c == 'T') {
                    n = Integer.parseInt(str);
                    if(c == 'S') {
                        game[index] = (int)Math.pow(n, 1);
                        index++;
                    } else if(c == 'D') {
                        game[index] = (int)Math.pow(n, 2);
                        index++;
                    } else {
                        game[index] = (int)Math.pow(n, 3);
                        index++;
                    }
                    str = "";
                } else {
                    if(c == '*') {
                        game[index - 1] *= 2;
                        if(index - 2 >= 0) {
                            game[index - 2] *= 2;
                        }
                    } else {
                        game[index - 1] *= (-1);
                    }
                }
            }

            answer = game[0] + game[1] + game[2];
            return answer;
        }
    }
}
