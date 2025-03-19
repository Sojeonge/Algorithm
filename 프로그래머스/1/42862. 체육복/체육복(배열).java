import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] stu = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            stu[i] = 1;
        }
        
        for (int i : reserve) {
            stu[i]++;
        }
        
        Arrays.sort(lost);
        
        for (int i : lost) {
            if (stu[i] == 2) {
                stu[i]--;
            } else 
                stu[i]--;
        }
        
        for (int i = 1; i <= n; i++) {
            if (stu[i] == 0) {
                if (i - 1 > 0 && stu[i - 1] == 2) {
                    stu[i - 1] = 1;
                    stu[i] = 1;
                } else if (i + 1 <= n && stu[i + 1] == 2) {
                    stu[i + 1] = 1;
                    stu[i] = 1;
                } 
            }
        }
        
        int total = n;
        for (int i = 1; i <= n; i++) {
            if (stu[i] == 0) total--;
        }
  
        return total;
    }
}
