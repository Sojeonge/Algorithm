class Solution {
    static int count = Integer.MAX_VALUE;
    static boolean[] visited;
    static String[] wordList;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        wordList = words;
        
        dfs(begin, target, 0);
 
        return count == Integer.MAX_VALUE ? 0 : count;
    }
    
    private static void dfs(String current, String target, int depth) {
        System.out.println("📍 dfs(" + current + ", depth=" + depth + ")");
        
        if (current.equals(target)) {
            count = Math.min(count, depth);
            return;
        }
        
        for (int i = 0; i < wordList.length; i++) {
            if (!visited[i] && isOneDiff(current, wordList[i])) {
                visited[i] = true;
                System.out.println("→ 이동: " + current + " → " + wordList[i]);
                dfs(wordList[i], target, depth + 1);
                visited[i] = false;
                System.out.println("↩️ 백트래킹: " + wordList[i] + " → " + current+ ", visited[" + i + "] = " + visited[i]);
            }
        }    
    }
    
    private static boolean isOneDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        
        return diff == 1;
    }
}
