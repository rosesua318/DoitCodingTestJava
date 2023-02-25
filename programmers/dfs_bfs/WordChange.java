package programmers.dfs_bfs;

public class WordChange {
    class Solution {
        static boolean[] visited;
        static int answer = 0;
        public int solution(String begin, String target, String[] words) {
            visited = new boolean[words.length];
            dfs(begin, target, words, 0);
            return answer;
        }

        public static void dfs(String begin, String target, String[] words, int count) {
            if(begin.equals(target)) {
                answer = count;
                return;
            }
            for(int i = 0; i < words.length; i++) {
                if(visited[i]) {
                    continue;
                }

                int k = 0;    // 같은 스펠링 개수
                for(int j = 0; j < begin.length(); j++) {
                    if(begin.charAt(j) == words[i].charAt(j)) {
                        k++;
                    }
                }

                if(k == begin.length() - 1) {  // 한글자 빼고 모두 같은 경우
                    visited[i] = true;
                    dfs(words[i], target, words, count + 1);
                    visited[i] = false; // 백트래킹
                }
            }
        }
    }
}