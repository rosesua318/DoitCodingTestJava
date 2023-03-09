package programmers.level1;

public class NewId {
    class Solution {
        public String solution(String new_id) {
            String answer = new_id.toLowerCase(); // 소문자로
            answer = answer.replaceAll("[^-_.a-z0-9]", ""); // -_.와 영문자, 숫자만 남김
            answer = answer.replaceAll("[.]{2,}", "."); // .2개 이상을 .으로
            answer = answer.replaceAll("^[.]|[.]$", ""); // 처음과 끝 . 제거

            if(answer.equals("")) { // 빈 문자열인 경우
                answer += "a"; // a 추가
            }

            if(answer.length() >= 16) { // 16자 이상인 경우
                answer = answer.substring(0, 15); // 15자로 만들기
                answer = answer.replaceAll("^[.]|[.]$", ""); // 끝 . 제거
            }
            if(answer.length() <= 2) { // 2자 이하인 경우
                while(answer.length() < 3) { // 길이가 3이 될 때까지 마지막 문자 붙이리
                    answer += answer.charAt(answer.length() - 1);
                }
            }

            return answer;
        }
    }
}
