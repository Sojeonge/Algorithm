import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[][] stu = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] count = new int[stu.length];
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < stu.length; j++) {
                if (answers[i] == stu[j][(i % stu[j].length)]) {
                    count[j] += 1;
                }
            }
        }
        
        int max = Math.max(count[0],Math.max(count[1], count[2]));
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < count.length; i++) {
            if (max == count[i]) {
                list.add(i + 1);
            }
        }
    
        return list.stream().mapToInt(i->i).toArray();

        // int[] result = new int[list.size()];
        // for (int i = 0; i < list.size(); i++) {
        //     result[i] = list.get(i);
        // }
    
        // return result;
    }
}
