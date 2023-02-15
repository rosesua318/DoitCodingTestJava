package programmers.hash;

import java.util.*;

public class Phoneketmon {
    class Solution {
        public int solution(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            int n = nums.length / 2;
            for(int num : nums) {
                set.add(num); // 중복 제거되며 추가됨
            }

            // 중복 제거하고나서 set의 크기가 nums.length / 2보다 크면 nums.length / 2를 리턴 작으면 set의 size를 리턴
            if(set.size() > n) {
                return n;
            } else {
                return set.size();
            }
        }
    }
    public static void main(String[] args) {

    }
}
