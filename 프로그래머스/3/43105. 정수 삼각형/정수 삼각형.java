class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;
        int[][] dp = new int[height][height];
        
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < height; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
        }
        
        for (int i = 1; i < height; i++) {
            for (int j = 1; j <= i; j++) {
                int left = dp[i - 1][j - 1] + triangle[i][j];
                int right = dp[i - 1][j] + triangle[i][j];
                dp[i][j] = Math.max(left, right);      
            }
        }
        
        for (int i = 0; i < height; i++) {
            answer = Math.max(dp[height - 1][i], answer);
        }      
        
        return answer;
    }
}