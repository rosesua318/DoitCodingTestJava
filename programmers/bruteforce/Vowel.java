package programmers.bruteforce;

import java.util.*;

public class Vowel {
    class Solution {
        static String[] arr = {"A", "E", "I", "O", "U"};
        static List<String> list;
        public int solution(String word) {
            int answer = 0;
            list = new ArrayList<>();

            dfs(word, "", 0);

            // 선형 탐색
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).equals(word)) {
                    answer = i;
                    break;
                }
            }

            return answer;
        }

        static void dfs(String word, String str, int depth) {
            list.add(str);
            if(depth == 5) {
                return;
            }
            for(int i = 0; i < arr.length; i++) {
                dfs(word, str + arr[i], depth + 1);
            }
        }
    }
}
