package programmers.bruteforce;

import java.util.*;

public class MockExam {
    class Solution {
        public int[] solution(int[] answers) {
            int[] first = { 1, 2, 3, 4, 5 }; // 1번 수포자(5개씩 반복)
            int[] second = { 2, 1, 2, 3, 2, 4, 2, 5 }; // 2번 수포자(8개씩 반복)
            int[] third = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 3번 수포자(10개씩 반복)
            int[] score = { 0, 0, 0 }; // 수포자들의 각 점수

            for(int i = 0; i < answers.length; i++) {
                if(answers[i] == first[i % 5]) {
                    score[0]++;
                }
                if(answers[i] == second[i % 8]) {
                    score[1]++;
                }
                if(answers[i] == third[i % 10]) {
                    score[2]++;
                }
            }

            int max = Math.max(score[0], Math.max(score[1], score[2]));

            ArrayList<Integer> arr = new ArrayList<Integer>();
            for(int i = 0; i < score.length; i++) {
                if(max == score[i]) {
                    arr.add(i + 1);
                }
            }

            int[] answer = new int[arr.size()];
            for(int i = 0; i < arr.size(); i++) {
                answer[i] = arr.get(i);
            }

            return answer;
        }
    }
}
