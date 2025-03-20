import java.util.*;

class Solution {
    public String solution(String number, int k) {
        char[] input = number.toCharArray();
        
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            while (!temp.empty() && k > 0 && temp.peek() < input[i]) {
                k--;
                temp.pop();
            }
            
            temp.push(input[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!temp.empty()) {
            if (k != 0) {
                temp.pop();
                k--;
            } else {
                sb.append(temp.pop());
            }
        }
        
        return sb.reverse().toString();        
    }
}