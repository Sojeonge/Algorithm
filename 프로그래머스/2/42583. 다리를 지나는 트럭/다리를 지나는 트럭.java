import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        Queue<Integer> queue = new LinkedList<>();
    
        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }
        
        // if (bridge_length == 1) return truck_weights.length + 1;
        // if (truck_weights.length == 1) return bridge_length + 1;
        
        int index = 0;
        
        while(!queue.isEmpty()) {
            answer++;
            totalWeight -= queue.poll();
            
            if (index < truck_weights.length) {
                if (totalWeight + truck_weights[index] <= weight) {
                    queue.add(truck_weights[index]);
                    totalWeight += truck_weights[index];
                    index++;
                } else {
                    queue.add(0);
                }
            }         
        }
        return answer;
    }
}