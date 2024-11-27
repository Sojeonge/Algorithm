import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // 바위 배열을 정렬합니다.
        Arrays.sort(rocks);
        
        // 이진 탐색의 시작점과 끝점을 설정합니다.
        int start = 0, end = distance;

        while (start <= end) {
            // 중간값 계산
            int mid = (start + end) / 2;
            int previousRock = 0; // 이전 바위 위치
            int removedRocks = 0; // 제거한 바위 수
            
            // 바위를 순회하면서 제거해야 하는 바위의 수 계산
            for (int rock : rocks) {
                if (rock - previousRock < mid) {
                    removedRocks++; // 간격이 mid보다 작으면 바위 제거
                } else {
                    previousRock = rock; // 간격이 충분하면 이전 바위 위치 갱신
                }
            }
            
            // 마지막 거리와 도착 지점 사이도 확인
            if (distance - previousRock < mid) {
                removedRocks++;
            }

            // 제거한 바위 수가 n보다 많으면 mid를 줄인다.
            if (removedRocks > n) {
                end = mid - 1;
            } else { // 아니라면 mid를 키운다.
                start = mid + 1;
            }
        }
        
        // 최적의 최솟값 반환
        return end;
    }
}
