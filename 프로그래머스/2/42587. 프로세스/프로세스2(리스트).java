import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }
        
        while (!queue.isEmpty()) {
            int[] current = queue.remove(0); // poll() 불가능! -> List 타입이라서
            boolean hasHigherPriority = false;
            
            for (int i = 0; i < queue.size(); i++) { // current 보다 큰 값 있는지 찾기
                int[] q = queue.get(i);
                if (q[1] > current[1]) {
                    queue.add(current);
                    hasHigherPriority = true;
                    break;
                }
            }
            
            if (!hasHigherPriority) {
                answer++;
                if (current[0] == location) {
                    return answer;
                } 
            }
                 
        }
         
        return answer;
    }
}
