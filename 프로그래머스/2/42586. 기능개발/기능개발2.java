import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();

        int temp = 0;
        for (int i = 0; i < progresses.length; i++) {
            int current = (100 - progresses[i]) / speeds[i];
            if (temp < current) {
                temp = current;
                list.add(1);
            } else list.set(list.size() - 1, list.get(list.size() - 1) + 1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
        // return list.stream().mapToInt(i -> i).toArray();

      // int[] answer = new int[list.size()];
      //   for (int i = 0; i < list.size(); i++) {
      //       answer[i] = list.get(i);
      //   }
        
      //   return answer;
    }
}
