import java.util.*;

class Solution {
    static int[] number;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        
        number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = i;
        }
        
        int cnt = 0;
        for (int i = 0; i < costs.length; i++) {
            if (find(costs[i][0]) == find(costs[i][1]))
                continue;
            union(costs[i][0], costs[i][1]);
            answer += costs[i][2];
            cnt++;
            if(cnt == n - 1)
                break;
        }
        return answer;
    }
    
    static int find(int a) {
        if (a == number[a]) 
            return a;
        return number[a] = find(number[a]);
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a < b) number[b] = a;
        else number[a] = b;
    }   
}
