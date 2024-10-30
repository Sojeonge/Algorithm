import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        Queue<String> queue = new LinkedList<>();
        
        queue.add(begin);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int s = 0; s < size; s++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return answer;
                }

                for (int i = 0; i < words.length; i++) {
                    if (!visited[i] && canTrans(current, words[i])) {
                        visited[i] = true;
                        queue.add(words[i]);
                    }
                }
            }
            answer++; 
        }
        
        return 0; 
    }
    
static boolean canTrans(String word1, String word2) {
    int diffCount = 0;
    for (int i = 0; i < word1.length(); i++) {
        if (word1.charAt(i) != word2.charAt(i)) {
            diffCount++;
        }
    }
    return diffCount == 1;
}        
}    
