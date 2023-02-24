package programmers.dp;

public class Thievery {
    class Solution {
        public int solution(int[] money) {
            int[] df = new int[money.length];
            int[] ds = new int[money.length];

            for(int i = 0; i < money.length; i++) {
                df[i] = money[i];
                ds[i] = money[i];
            }
            df[1] = -1;
            ds[0] = -1;
            df[2] += df[0];
            for(int i = 3; i < money.length; i++) {
                df[i] += Math.max(df[i - 2], df[i - 3]);
                ds[i] += Math.max(ds[i - 2], ds[i - 3]);
            }
            int fmax = Math.max(df[money.length - 2], df[money.length - 3]);
            int smax = Math.max(ds[money.length - 1], ds[money.length - 2]);

            return Math.max(fmax, smax);
        }
    }
}
