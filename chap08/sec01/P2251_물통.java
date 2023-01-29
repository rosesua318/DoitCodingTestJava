package chap08.sec01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ab 클래스 선언 => a와 b의 값만 지니고 있으면 c는 유추할 수 있으므로 두 변수만 사용하기
class ab {
    int a;
    int b;
    public ab(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class P2251_물통 {
    // 6가지 이동 케이스를 표현하기 위한 배열;
    static int[] sender = { 0, 0, 1, 1, 2, 2 };
    static int[] receiver = { 1, 2, 0, 2, 0, 1 };
    static boolean visited[][]; // a, b의 무게만 있으면 c의 무게가 고정되므로 2개만 체크
    static boolean answer[];
    static int now[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        now = new int[3]; // a, b, c 물의 양을 저장하는 배열
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();
        visited = new boolean[201][201];
        answer = new boolean[201];

        bfs();
        for(int i = 0; i < answer.length; i++) {
            if(answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void bfs() {
        Queue<ab> queue = new LinkedList<>();
        queue.add(new ab(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;
        while(!queue.isEmpty()) {
            ab p = queue.peek();
            int a = p.a;
            int b = p.b;
            int c = now[2] - a - b; // c는 전체 물의 양에서 a와 b를 뺀 것
            for(int k = 0; k < 6; k++) { // a->b, a->c, b->a, b->c, c->a, c->b
                int[] next = {a, b, c};
                next[receiver[k]] += next[sender[k]];
                next[sender[k]] = 0;
                if(next[receiver[k]] > now[receiver[k]]) { // 물이 넘칠 때
                    // 초과하는 만큼 다시 이전 물통에 넣어 줌
                    next[sender[k]] = next[receiver[k]] - now[receiver[k]];
                    next[receiver[k]] = now[receiver[k]]; // 대상 물통은 최대로 채워 줌
                }

                if(!visited[next[0]][next[1]]) { // a와 b의 물의 양을 이용해 방문 배열 체크
                    visited[next[0]][next[1]] = true;
                    queue.add(new ab(next[0], next[1]));
                    if(next[0] == 0) { // a의 물의 양이 0일 때 c의 물의 무게를 정답 변수에 저장
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}
