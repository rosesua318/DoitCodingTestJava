package programmers.level1;

public class WallPaper {
    class Solution {
        public int[] solution(String[] wallpaper) {
            int sx = Integer.MAX_VALUE;
            int sy = Integer.MAX_VALUE;
            int ex = 0;
            int ey = 0;
            for(int i = 0; i < wallpaper.length; i++) {
                for(int j = 0; j < wallpaper[i].length(); j++) {
                    if(wallpaper[i].charAt(j) == '#') {
                        sx = Math.min(sx, i);
                        sy = Math.min(sy, j);
                        ex = Math.max(ex, i + 1);
                        ey = Math.max(ey, j + 1);
                    }
                }
            }
            return new int[]{sx, sy, ex, ey};
        }
    }
}
