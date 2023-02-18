package programmers.sort;

import java.util.*;

public class Kth {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            for(int i = 0; i < commands.length; i++) {
                int num1 = commands[i][0];
                int num2 = commands[i][1];
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j = num1 - 1; j < num2; j++) {
                    temp.add(array[j]);
                    Collections.sort(temp);
                }
                list.add(temp);
            }

            for(int i = 0; i < commands.length; i++) {
                answer[i] = list.get(i).get(commands[i][2] - 1);
            }

            return answer;
        }
    }
}
