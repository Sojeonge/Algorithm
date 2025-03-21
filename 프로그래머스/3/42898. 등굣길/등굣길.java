class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] dp = new int[n][m];
        
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        dp[0][0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) continue;
                
                if (i > 0 && dp[i - 1][j] > 0) {
                    dp[i][j] += dp[i - 1][j]; // 위에서 
                }
                
                if (j > 0 && dp[i][j - 1] > 0) {
                    dp[i][j] += dp[i][j - 1]; // 왼쪽에서
                }
                
                dp[i][j] %= mod; // 수가 커지는 것을 대비해 미리 나눠주기
            }
        }
        
        return dp[n - 1][m - 1];
    }
}
