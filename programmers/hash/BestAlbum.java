package programmers.hash;

import java.util.*;

public class BestAlbum {
    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            ArrayList<Integer> answer = new ArrayList<>();

            HashMap<String, Integer> gmap = new HashMap<>(); // 장르별 총 개수
            HashMap<String, HashMap<Integer, Integer>> mmap = new HashMap<>(); // 장르에 속하는 노래와 재생횟수
            for(int i = 0; i < plays.length; i++) {
                if(!gmap.containsKey(genres[i])) { // 장르가 해시맵에 없다면
                    HashMap<Integer, Integer> map = new HashMap<>();
                    map.put(i, plays[i]); // 고유번호, 재생횟수 저장
                    mmap.put(genres[i], map);
                    gmap.put(genres[i], plays[i]);
                } else {
                    mmap.get(genres[i]).put(i, plays[i]);
                    gmap.put(genres[i], gmap.get(genres[i]) + plays[i]);
                }
            }

            List<String> keySet = new ArrayList(gmap.keySet());
            Collections.sort(keySet, (s1, s2) -> gmap.get(s2) - (gmap.get(s1))); // 내림차순 정렬

            for(String key : keySet) {
                HashMap<Integer, Integer> map = mmap.get(key);
                List<Integer> genre_key = new ArrayList(map.keySet());

                Collections.sort(genre_key, (s1, s2) -> map.get(s2) - (map.get(s1))); // 내림차순 정렬

                answer.add(genre_key.get(0));
                if(genre_key.size() > 1)
                    answer.add(genre_key.get(1));
            }

            return answer.stream().mapToInt(i -> i).toArray();
        }
    }

    public static void main(String[] args) {
        
    }
}
