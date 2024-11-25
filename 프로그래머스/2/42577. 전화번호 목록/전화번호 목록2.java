import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i]))
                return false;
    }
    return true;
  }
    // public static void main(String[] args) {
    //     Solution sol = new Solution();
    //     String[] phone_book = {"12", "123", "1235", "567", "88"};
    //     boolean result = sol.solution(phone_book);
    //     System.out.println("Result: " + result);
    // }
}
