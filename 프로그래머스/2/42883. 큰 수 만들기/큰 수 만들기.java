import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        
        for (int i = 1; i < sb.length() && k > 0; i++) {
            if (sb.charAt(i - 1) < sb.charAt(i)) {
                sb.deleteCharAt(i - 1);
                k--;
                i = Math.max(0, i - 2);
            }
        }
        
        return sb.substring(0, sb.length() - k);       
    }
}