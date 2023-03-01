package programmers.level1;

public class CaesarCipher {
    class Solution {
        public String solution(String s, int n) {
            String answer = "";
            for(char c : s.toCharArray()) {
                if(c == ' ') { // 공백인 경우
                    answer += c;
                    continue;
                }
                if(Character.isLowerCase(c)) { // 소문자인 경우
                    if(c + n > 'z') {
                        answer += (char)(c - 26 + n);
                    } else {
                        answer += (char)(c + n);
                    }
                } else if(Character.isUpperCase(c)) { // 대문자인 경우
                    if(c + n > 'Z') {
                        answer += (char)(c - 26 + n);
                    } else {
                        answer += (char)(c + n);
                    }
                }
            }
            return answer;
        }
    }
}
