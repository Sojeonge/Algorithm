import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] useTickets;
    
    public String[] solution(String[][] tickets) {
        useTickets = new boolean[tickets.length];
        
        dfs (0, "ICN", "ICN", tickets);
        
        Collections.sort(list); // sort() = 오름차순, reverse() = 내림차순
        return list.get(0).split(" "); // 배열 형태로 출력
    }
    
    static void dfs (int depth, String now, String path, String[][] tickets) {
        if (depth == tickets.length) {
            list.add(path);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!useTickets[i] && now.equals(tickets[i][0])) { // 문자열 => equals() 사용
                useTickets[i] = true;
                dfs (depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                useTickets[i] = false;
            }
        }
    }
}
