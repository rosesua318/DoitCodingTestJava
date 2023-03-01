package programmers.level1;

public class StrangeCharacter {
    class Solution {
        public String solution(String s) {
            String answer = "";
            String[] str = s.split("");

            int index = 0;
            for(int i = 0; i < str.length; i++) {
                if(str[i].equals(" ")) {
                    index = 0;
                } else if(index % 2 == 0) {
                    str[i] = str[i].toUpperCase();
                    index++;
                } else {
                    str[i] = str[i].toLowerCase();
                    index++;
                }
                answer += str[i];
            }

            return answer;
        }
    }
}
