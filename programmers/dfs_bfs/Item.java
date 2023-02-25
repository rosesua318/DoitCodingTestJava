package programmers.dfs_bfs;

import java.util.*;

public class Item {
    class Solution {
        static final int[] moveX = new int[]{1, -1, 0, 0},
                moveY = new int[]{0, 0, 1, -1};
        static class Node {
            int x;
            int y;
            int count;
            public Node(int x, int y, int count) {
                this.x = x;
                this.y = y;
                this.count = count;
            }
        }

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            Boolean[][] way = new Boolean[102][102];
            characterX *= 2;
            characterY *= 2;
            itemX *= 2;
            itemY *= 2;

            for(int i = 0; i < rectangle.length; i++) {
                int[] current = rectangle[i];
                for(int j = 0; j < 4; j++) {
                    current[j] *= 2;
                }
                for(int x = current[0]; x <= current[2]; x++) {
                    for(int y = current[1]; y <= current[3]; y++) {
                        way[x][y] = (x == current[0] || x == current[2] || y == current[1] || y == current[3]) && way[x][y] != Boolean.FALSE;
                    }
                }

            }

            Queue<Node> queue = new LinkedList<>();
            way[characterX][characterY] = Boolean.FALSE;
            queue.offer(new Node(characterX, characterY, 0));
            int min = Integer.MAX_VALUE;

            while(!queue.isEmpty()) {
                Node node = queue.poll();
                if(node.x == itemX && node.y == itemY && min > node.count) {
                    min = node.count;
                    continue;
                }
                for(int i = 0; i < 4; i++) {
                    int x = node.x + moveX[i];
                    int y = node.y + moveY[i];
                    if(x < 2 || y < 2 || x > 100 || y > 100) continue;
                    if(way[x][y] != Boolean.TRUE) continue;
                    way[x][y] = Boolean.FALSE;
                    queue.offer(new Node(x, y, node.count + 1));
                }
            }
            return min / 2;
        }
    }
}
