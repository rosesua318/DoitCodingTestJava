package programmers.dfs_bfs;

import java.util.*;

public class GameMap {
    class Solution {
        public class Node {
            int x;
            int y;
            int cost;
            public Node(int x, int y, int cost) {
                this.x = x;
                this.y = y;
                this.cost = cost;
            }
        }

        static int[] dx = {0, 1, 0, -1};
        static int[] dy = {-1, 0, 1, 0};
        static boolean[][] visited;
        static int n, m;
        public int solution(int[][] maps) {
            n = maps.length;
            m = maps[0].length;
            visited = new boolean[n][m];
            return bfs(0, 0, maps);
        }

        public int bfs(int x, int y, int[][] maps) {
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(x, y, 1));
            visited[x][y] = true;

            while(!q.isEmpty()) {
                Node node = q.poll();
                if(node.x == n - 1 && node.y == m - 1) { // 상대 팀 진영에 도착했을 때
                    return node.cost;
                }
                for(int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.offer(new Node(nx, ny, node.cost + 1));
                        }
                    }
                }
            }
            return -1; // 상대 팀 진영에 도착할 수 없을 때
        }
    }

}

