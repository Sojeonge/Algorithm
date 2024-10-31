class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int[] list = {};
        
        for (int[] command : commands) {
            for(int i = command[0] - 1; i < command[1]; i++) {
                list.add(array[i] + " ");
            }
            answer.add(list.sort(command[2] - 1).split(" "));   
        } 
        return answer;
    }
}