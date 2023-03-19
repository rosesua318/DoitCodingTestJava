package programmers.level1;

import java.util.*;
import java.util.stream.*;

public class NumberPartner {
    class Solution {
        public String solution(String X, String Y) {
            HashMap<String, Integer> xmap = new HashMap<>();
            HashMap<String, Integer> ymap = new HashMap<>();
            ArrayList<String> arr = new ArrayList<>();

            for(String s : X.split("")) {
                xmap.put(s, xmap.getOrDefault(s, 0) + 1);
            }
            for(String s : Y.split("")) {
                ymap.put(s, ymap.getOrDefault(s, 0) + 1);
            }

            for(String key: xmap.keySet()) {
                if(!ymap.containsKey(key)) {
                    continue;
                }
                int length = Math.min(xmap.get(key), ymap.get(key));
                for(int i = 0; i < length; i++) {
                    arr.add(key);
                }
            }

            String answer = arr.stream()
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.joining());

            if(answer.isEmpty()) {
                return "-1";
            }
            if(answer.replaceAll("0", "").isEmpty()) {
                return "0";
            }
            return answer;
        }
    }
}
