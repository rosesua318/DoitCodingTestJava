package programmers.level1;

import java.util.*;

public class ReportResult {
    class Solution {
        public static int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            Map<String, HashSet<String>> rmap = new HashMap<>(); // [신고된ID, [신고한ID]]
            Map<String, Integer> amap = new HashMap<>(); // [신고된ID, 메일 수]

            for(int i = 0; i < id_list.length; i++) {
                HashSet<String> rId = new HashSet<>();
                rmap.put(id_list[i], rId);
                amap.put(id_list[i], 0);  // 메일 수 0 으로 초기화
            }

            for(String str : report) {
                String[] rstr = str.split(" ");
                rmap.get(rstr[1]).add(rstr[0]); // 신고된ID를 key 값으로 신고한ID 배열 요소를 value로 저장
            }

            // 사용자가 받은 이용 정지 결과 메일 세팅하기
            for(String rid : rmap.keySet()) { // 신고된ID 모음
                HashSet<String> ruser = rmap.get(rid); // 신고한 사용자들
                if(ruser.size() >= k) { // 신고된 횟수가 K번 이상일 경우
                    for(String user : ruser) {
                        amap.put(user, amap.get(user) + 1); // amap에 신고된Id 별 메일 수 저장
                    }
                }
            }

            for (int i = 0; i < id_list.length; i++) {
                answer[i] = amap.get(id_list[i]);
            }
            return answer;
        }
    }
}
