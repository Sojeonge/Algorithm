import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<int[]> list = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            list.add(new int[]{i, priorities[i]});
        }
        
        while (!list.isEmpty()) {
            int[] current = list.remove(0);
            boolean hasHigherPriority = false;
            
            for (int i = 0; i < list.size(); i++) {
                int[] q = list.get(i);
                if (current[1] < q[1]) {
                    list.add(current);
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
