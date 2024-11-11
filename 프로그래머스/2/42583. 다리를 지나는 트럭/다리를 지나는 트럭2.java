import java.util.*;

class Solution {
    class Truck {
        int weight;
        int move;
        
        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }
        
        public void moving() {
            move++;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitQ = new LinkedList<>(); // 타입 지정 (Truck)
        Queue<Truck> moveQ = new LinkedList<>();
        
        for (int t : truck_weights) {
            waitQ.offer(new Truck(t));
        }
        
        int answer = 0;
        int curWeight = 0;
        
        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;
            
            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }
            
            for (Truck t : moveQ) {
                t.moving();
            }
            
            if (moveQ.peek().move > bridge_length) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }
            
            // 현재 대기중인 틀럭이 있을 때
            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }
        return answer;
        
    }
}
