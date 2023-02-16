package programmers.stack_queue;

import java.util.*;

public class RightBracket {
    class Solution {
        boolean solution(String s) {
            boolean answer = true;
            Stack<Character> stack = new Stack<>();

            for(char x : s.toCharArray()) {
                if(x == '(') {
                    stack.push(x);
                } else {
                    // 닫는 괄호가 많은 상황
                    if(stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }

            // 여는 괄호가 많은 상황
            if(!stack.isEmpty()) {
                return false;
            }

            return answer;
        }
    }

    public static void main(String[] args) {

    }
}
