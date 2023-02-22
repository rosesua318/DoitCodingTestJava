package programmers.greedy;

import java.util.*;

public class Island {
    class Solution {
        public int solution(int n, int[][] costs) {
            int answer = 0;
            int[] parent = new int[n];

            for(int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            Arrays.sort(costs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2]; // 비용을 기준으로 오름차순 정렬
                }
            });

            for (int i = 0; i < costs.length; i++) {
                // 사이클 판독
                if(find(parent, costs[i][0]) != find(parent, costs[i][1])) {
                    answer += costs[i][2];
                    union(parent, costs[i][0], costs[i][1]);
                }
            }
            return answer;
        }
        public int find(int[] parent, int node) {
            if(parent[node] == node)
                return node;
            return find(parent, parent[node]);
        }
        public void union(int[] parent, int node1, int node2) {
            int p1 = find(parent, node1);
            int p2 = find(parent, node2);

            if (p1 < p2) parent[p2] = p1;
            else parent[p1] = p2;
        }
    }
}
