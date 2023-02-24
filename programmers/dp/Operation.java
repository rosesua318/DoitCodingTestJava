package programmers.dp;

public class Operation {
    class Solution {
        int dp[][][] = new int[2][200][200];  // 1차원 0 - 최대, 1 - 최소
        char op[]; // 연산자
        int nums[]; // 숫자
        String arr[];
        int tmp = 987654321;

        // flag 0이면 최대, 1이면 최소
        public int solve(int flag, int start, int end) {
            // 범위가 숫자 하나로 일치하는 경우
            if(start == end) {
                return dp[flag][start][end] = nums[start];
            }

            // 이미 해결했던 문제인 경우
            if((flag == 0 && dp[flag][start][end] != -1 * tmp) ||
                    flag == 1 && dp[flag][start][end] != tmp) {
                return dp[flag][start][end];
            }

            // flag에 따라 초기값을 다르게 줌
            int ret;
            if(flag == 0) {
                ret = -1 * tmp;
            } else {
                ret = tmp;
            }

            // 방문 체크
            dp[flag][start][end] = 0;

            if(flag == 0) { // 최대를 구해야 하는 경우
                for(int mid = start; mid < end; mid++) {
                    if(op[mid] == '-') { // 구간 사이의 연산자가 "-"일때, 최대 - 최소
                        ret = Math.max(ret, solve(0, start, mid) - solve(1, mid + 1, end));
                    } else { // 구간 사이의 연산자가 "+"일때, 최대 + 최대
                        ret = Math.max(ret, solve(0, start, mid) + solve(0, mid + 1, end));
                    }
                }
            } else { // 최소를 구해야 하는 경우
                for(int mid = start; mid < end; mid++) {
                    if(op[mid] == '-') { // 구간 사이의 연산자가 "-"일때, 최소 - 최대
                        ret = Math.min(ret, solve(1, start, mid) - solve(0, mid + 1, end));
                    }
                    else { // 구간 사이의 연산자가 "+"일때, 최소 + 최소
                        ret = Math.min(ret, solve(1, start, mid) + solve(1, mid + 1, end));
                    }
                }
            }

            return dp[flag][start][end] = ret;
        }

        public int solution(String arr[]) {
            int answer = -1;

            int n = arr.length / 2;
            for(int i = 0; i < n + 1; i++) { // dp 테이블 초기화
                for(int j = 0; j < n + 1; j++) {
                    dp[0][i][j] = -1 * tmp;
                    dp[1][i][j] = tmp;
                }
            }

            nums = new int[n + 1];
            op = new char[n];

            // arr의 짝수 idx는 숫자, 홀수 idx는 연산자
            for(int i = 0; i < arr.length; i++) {
                if(i % 2 == 0) {
                    nums[i / 2] = Integer.parseInt(arr[i]);
                } else {
                    op[i / 2] = arr[i].charAt(0);
                }
            }

            return answer = solve(0, 0, arr.length / 2); // 처음부터 끝까지의 최대값
        }
    }
}
