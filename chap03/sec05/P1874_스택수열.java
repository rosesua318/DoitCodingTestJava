package chap03.sec05;

import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int num = 1; // 오름차순 수
        boolean result = true;

        for(int i = 0; i < arr.length; i++) {
            int su = arr[i]; // 현재 수열의 수
            if(su >= num) { // 현재 수열 값 >= 오름차순 자연수 : 값이 같아질 때까지 push() 수행
                while(su >= num) { // push()
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else { // 현재 수열 값 < 오름차순 자연수 : pop()을 수행해 수열 원소를 꺼냄
                int m = stack.pop();
                // 스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력할 수 없음
                if(m > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }

        if(result) {
            System.out.println(sb.toString());
        }
    }
}
