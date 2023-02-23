package programmers.dp;

import java.util.*;

public class N {
    class Solution {
        public void union(Set<Integer> set, Set<Integer> a, Set<Integer> b) {
            for(int n1 : a) {
                for(int n2 : b) {
                    set.add(n1 + n2);
                    set.add(n1 - n2);
                    set.add(n1 * n2);
                    if(n2 != 0)
                        set.add(n1 / n2);
                }
            }
        }
        public int solution(int N, int number) {
            List<Set<Integer>> list = new ArrayList<>();

            for(int i = 0; i < 9; i++) {
                list.add(new HashSet<>());
            }
            list.get(1).add(N); // 1개로 만들 수 있는 건 자기 자신뿐
            if(number == N) {
                return 1;
            }
            for(int i = 2; i < 9; i++) {
                for(int j = 1; j <= i / 2; j++) {
                    union(list.get(i), list.get(i - j), list.get(j));
                    union(list.get(i), list.get(j), list.get(i - j));
                }
                String n = Integer.toString(N);
                list.get(i).add(Integer.parseInt(n.repeat(i))); // i개의 연속된 숫자 넣기
                for(int num : list.get(i)) {
                    if(num == number) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }
}
