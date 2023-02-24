package programmers.dfs_bfs;

public class TargetNumber {
    class Solution {
        static int answer = 0;
        public int solution(int[] numbers, int target) {
            dfs(numbers, 0, target, 0);
            return answer;
        }
        public void dfs(int[] numbers, int depth, int target, int sum){
            if(depth == numbers.length) {
                if(target == sum) {
                    answer++;
                }
            } else {
                dfs(numbers, depth + 1, target, sum + numbers[depth]); // 해당 값을 더하고 다음 탐색
                dfs(numbers, depth + 1, target, sum - numbers[depth]); // 해당 값을 빼고 다음 탐색
            }
        }
    }
}
