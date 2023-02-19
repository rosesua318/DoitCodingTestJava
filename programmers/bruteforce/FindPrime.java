package programmers.bruteforce;

import java.util.*;

public class FindPrime {
    class Solution {
        static HashSet<Integer> set = new HashSet<>(); // 중복값 제거 위해
        static char[] arr; // 종이조각 저장
        static boolean[] visited; // 사용여부

        public int solution(String numbers) {
            int answer = 0;
            arr = new char[numbers.length()];
            visited = new boolean[numbers.length()];

            for(int i = 0; i < numbers.length(); i++) {
                arr[i] = numbers.charAt(i);
            }

            dfs("", 0);

            answer = set.size();
            return answer;
        }

        // dfs 재귀. 가능한 숫자 조합 찾아서 소수면 set에 추가
        public void dfs(String str, int index){
            int num;
            if(str != "") {
                num = Integer.parseInt(str);
                if(isPrime(num)) { // 소수라면
                    set.add(num); // set에 추가
                }
            }
            if(index == arr.length) { // 끝까지 했을 경우
                return;
            }

            for(int i = 0; i < arr.length; i++) {
                if(visited[i]) continue; // 방문한 노드면 넘어가기
                visited[i] = true;
                dfs(str + arr[i], index + 1); // 방문 했을 시 재귀
                visited[i] = false; // 백트래킹
            }
        }

        public boolean isPrime(int num) {
            if(num == 0 || num == 1) {
                return false;
            }
            for(int i = 2; i * i <= num; i++) {
                if(num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
