import java.util.*;

class Solution {
    static int n;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        n = words.length;
        boolean[] visited = new boolean[n];
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(begin);
        
        while (!queue.isEmpty()) {
            
            for (int i = 0; i < queue.size(); i++) {
                String current = queue.poll();
            
                if (current.equals(target)) return answer;
            
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && canTransfer(current, words[j])) {
                        visited[j] = true;
                        queue.offer(words[j]);
                    } 
                }
            }
            answer++;
        }
        return 0;
}
    
public boolean canTransfer(String a, String b) {
    int count = 0;
    for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) != b.charAt(i)) {
            count++;
        }
    }
    return count == 1;
}     
}