package programmers.level1;

import java.util.HashMap;

public class KeyBoard {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            HashMap<Character, Integer> map = new HashMap<>();
            int[] answer = new int[targets.length];

            for(String key : keymap) {
                for(int i = 0; i < key.length(); i++) {
                    char c = key.charAt(i);
                    if(!map.containsKey(c) || i < map.get(c)) {
                        map.put(c, i + 1);
                    }
                }
            }

            for(int i = 0; i < targets.length; i++) {
                int count = 0;
                for(int j = 0; j < targets[i].length(); j++) {
                    char c = targets[i].charAt(j);
                    if(!map.containsKey(c)) {
                        count = 0;
                        break;
                    } else {
                        count += map.get(c);
                    }
                }
                if(count == 0) {
                    answer[i] = -1;
                } else {
                    answer[i] = count;
                }
            }

            return answer;
        }
    }
}
