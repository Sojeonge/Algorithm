import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < speeds.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                queue.add((100 - progresses[i]) / speeds[i]);
            } else {
                queue.add(((100 - progresses[i]) / speeds[i]) + 1);
            }
        }
        
    //     for (int i = 0; i < speeds.length; i ++) {
    //         queue.add((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
    // }
        
        int maxDays = queue.poll();
        int count = 1;
        List<Integer> list = new ArrayList<>();;
        
        while(!queue.isEmpty()) {
            if (maxDays >= queue.peek()) {
                count++;
                queue.poll();
            } else {
                list.add(count);
                count = 1;
                maxDays = queue.poll();
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
} 