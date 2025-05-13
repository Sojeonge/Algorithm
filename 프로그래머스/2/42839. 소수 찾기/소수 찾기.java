import java.util.*;

class Solution {
    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean[] check;
    
    public int solution(String numbers) {
        int answer = 0;
        check = new boolean[7];
        
        for (int i = 0; i < numbers.length(); i++) {
            dfs(numbers, "", i + 1);
        }
        
        for (int i = 0; i < arr.size(); i++) {
            if (prime(arr.get(i))) answer++;
        }
            
        return answer;
    }
    
    static void dfs(String str, String temp, int count) {
        if (temp.length() == count) {
            int num = Integer.parseInt(temp);
        
            if (!arr.contains(num)) {
                arr.add(num);
            }
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(str, temp + str.charAt(i), count);
                check[i] = false;
            }
        }
    }
    
    
    static boolean prime(int num) {
        if (num < 2) return false;
        
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }    
}