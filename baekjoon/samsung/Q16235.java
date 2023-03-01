package baekjoon.samsung;

import java.io.*;
import java.util.*;

public class Q16235 {
    static int n, m, k;
    static int[][] map;
    static int[][] yb;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static LinkedList<Tree> trees;
    static Queue<Tree> dead;
    static int year;

    static class Tree {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    static void simulate() {
        while(true) {
            if (year == k) return;

            // 봄
            Iterator<Tree> iterator = trees.iterator();
            while(iterator.hasNext()) {
                Tree tree = iterator.next();
                int x = tree.x;
                int y = tree.y;
                int age = tree.age;
                if(map[x][y] - age < 0) {
                    // 즉시 죽음
                    dead.offer(tree);
                    iterator.remove();
                }else {
                    map[x][y] -= age;
                    tree.age += 1;
                }
            }

            // 여름
            while(!dead.isEmpty()) {
                Tree tree = dead.poll();
                map[tree.x][tree.y] += tree.age / 2;
            }

            // 가을
            LinkedList<Tree> babyTrees = new LinkedList<>();
            for(Tree tree : trees) {
                int x = tree.x;
                int y = tree.y;
                if(tree.age % 5 != 0) continue;
                for(int d = 0; d < 8; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 1 || ny < 1 || nx > n || ny > n) {
                        continue;
                    }
                    babyTrees.add(new Tree(nx, ny, 1));
                }
            }
            trees.addAll(0, babyTrees);

            // 겨울
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    map[i][j] += yb[i][j];
                }
            }
            year++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        yb = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = 5;
                yb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        trees = new LinkedList<>();
        dead = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            trees.add(new Tree(Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())));
        }

        year = 0;
        simulate();
        System.out.println(trees.size());
    }
}