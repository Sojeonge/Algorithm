import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        // 내림차순 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
                //오름차순 정렬 (o1+o2).compareTo(o1+o2);
            }
        });
        
        // Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        if (arr[0].equals("0")) return "0"; // 모든 숫자가 0인 경우 (맨 처음 숫자가 0인 경우)
        
        for (String num : arr) {
            answer += num;
        }
        
        return answer;
    }
}
