import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[] {i, priorities[i]});
            pq.add(priorities[i]);
        }
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            if (current[1] == pq.peek()) {
                pq.poll();
                answer++;
                
                if (current[0] == location) {
                    return answer;
                }
            } else {
                q.add(current);
            }   
        }
 
        return answer;
    }
}
