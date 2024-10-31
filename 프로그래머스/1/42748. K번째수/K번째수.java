import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            List<Integer> list = new ArrayList<>();
            
            for(int n = commands[i][0] - 1; n < commands[i][1]; n++) {
                list.add(array[n]);
            }
            
            Collections.sort(list);
            answer[i] = list.get(commands[i][2] - 1);       
        }
        return answer;
    }
}