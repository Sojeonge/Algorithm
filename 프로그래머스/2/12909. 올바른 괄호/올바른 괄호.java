class Solution {
    boolean solution(String s) {
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }

            // 중간에 balance가 음수가 되면 올바르지 않은 괄호 문자열
            if (balance < 0) {
                return false;
            }
        }

        // 모든 괄호를 처리하고 balance가 0이면 올바른 문자열
        return balance == 0;
    }
}
