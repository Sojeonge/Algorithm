class Solution {
    boolean visited[];
    int[][] data;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        data = computers;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        return answer;
    }
    
    void dfs(int node) {
        visited[node] = true;
        
        for(int i = 0; i < data[node].length; i++) {
            if(!visited[i] && data[node][i] == 1) {
                dfs(i);
            }
        }
    }
}