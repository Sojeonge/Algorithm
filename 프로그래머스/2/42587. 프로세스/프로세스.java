import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 프로세스와 우선순위 큐 준비
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[] {i, priorities[i]});
            pq.add(priorities[i]);
        }

        // 큐에서 꺼내면서 처리
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            // 우선순위가 더 높은 프로세스가 있으면 다시 큐에 넣기
            if (current[1] == pq.peek()) {
                pq.poll();  // 실행한 프로세스는 큐에서 제거
                answer++;
                if (current[0] == location) {
                    return answer;  // 목표 프로세스가 실행된 순서
                }
            } else {
                queue.add(current);  // 우선순위가 더 높은 프로세스가 있으면 뒤로 보내기
            }
        }

        return answer;
    }
}
