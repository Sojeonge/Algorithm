import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        Queue<Integer> queue = new LinkedList<>();
    
        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }
        
        // if (bridge_length == 1) return truck_weights.length + 1; // 다리길이가 1일 때
        // if (truck_weights.length == 1) return bridge_length + 1; // 트럭이 1대일 때
        
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
        // while(index < truck_weights.length) {
        //     answer++;
        //     totalWeight -= queue.poll();
            
        //     if (totalWeight + truck_weights[index] <= weight) {
        //         queue.add(truck_weights[index]);
        //         totalWeight += truck_weights[index];
        //         index++;
        //     } else {
        //         queue.add(0);
        //     }
        // }
        // answer+= bridge_length;
        
        // return answer;

        
        return answer;
    }
}
