import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : reserve) {
            map.put(i, 2);
        }
        
        Arrays.sort(lost);
        
        for (int i : lost) {
            map.put(i, map.getOrDefault(i, 1) - 1); // i가 있으면 value값 반환, 아니면 1 (1 - 1 = 0) 반환
        }
        
        for (int i : lost) {
            if (map.get(i) == 1) {
                continue;
            }
            
            if (i - 1 > 0 && map.getOrDefault(i - 1, 1) == 2) {
                map.put(i - 1, 1);
                map.put(i, 1);
            } else if (i + 1 <= n && map.getOrDefault(i + 1, 1) == 2) {
                map.put(i + 1, 1);
                map.put(i, 1);
            }
        }
        
        int total = n;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 0) total--;
        }
        
        return total;
    }
}