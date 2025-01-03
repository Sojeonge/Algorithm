class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        int depth = 0, sum = 0;
        dfs(numbers, target, depth, sum);
        return answer;
    }
    public void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) answer++;
        } else {
            dfs(numbers, target, depth + 1, sum + numbers[depth]);
            dfs(numbers, target, depth + 1, sum - numbers[depth]);
        }
    }
}