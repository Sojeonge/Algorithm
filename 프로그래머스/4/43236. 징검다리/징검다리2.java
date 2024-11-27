import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int start = 0, end = distance;

        while(start < end) {
            int mid = (start + end + 1) / 2;
            int keep = 0, remove = 0;

            for(int i = 0; i < rocks.length; i++) {
                if(rocks[i] - keep < mid) remove++;
                else
                    keep = rocks[i];
            }

            if(remove > n) end = mid - 1;
            else
                start = mid;
        }
        return start;
    }
}
