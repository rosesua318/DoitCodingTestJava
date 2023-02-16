package programmers.stack_queue;

import java.util.*;

public class BridgeTruck {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> queue = new LinkedList<>();
            int sum = 0;
            int time = 0;

            for(int i = 0; i < truck_weights.length; i++) {
                int truck = truck_weights[i];
                while(true) {
                    if(queue.isEmpty()) { // 다리 위에 어떤 트럭도 없음
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else if(queue.size() == bridge_length) { // 다리 길이만큼 큐에 트럭이 찬 경우
                        sum -= queue.poll(); // 다리 끝에 도달한 트럭 빼주기
                    } else { // 큐가 안 찼을 경우
                        // weight 값을 넘지 않는다면 새로운 트럭을 다리에 올리기
                        if(sum + truck <= weight) {
                            queue.add(truck);
                            sum += truck;
                            time++;
                            break;
                        } else { // 넘을 경우 0을 추가해서 큐에 있는 트럭이 다리를 건널 수 있게 함
                            queue.add(0);
                            time++;
                        }
                    }
                }
            }

            // 마지막 남은 트럭이 다리 길이만큼 지나가야하기에 다리 길이만큼 더해줌
            return time + bridge_length;
        }
    }

    public static void main(String[] args) {

    }
}
