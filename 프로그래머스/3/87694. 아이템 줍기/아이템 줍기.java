import java.util.*;

class Solution {
    static int[] dI = {1, -1, 0, 0};
    static int[] dJ = {0, 0, 1, -1};
    static int[][] map = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int answer = 0;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        fills(rectangle);
        
        bfs (characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return answer;     
    }
    
    static void fills(int[][] rectangle) {
        for (int[] rect : rectangle) {
            int startI = rect[1] * 2;
            int endI = rect[3] * 2;
            
            int startJ = rect[0] * 2;
            int endJ = rect[2] * 2;
            
            for (int i = startI; i <= endI; i++) {
                for (int j = startJ; j <= endJ; j++) {
                    if (i == startI || i == endI || j == startJ || j == endJ) {
                        if (map[i][j] == 2) {
                            continue;
                        } 
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }
    }
    
     static void bfs (int characterX, int characterY, int itemX, int itemY) {
         Queue<int[]> queue = new LinkedList<>();
         queue.add(new int[]{characterY, characterX, 0});
         
         while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentI = current[0];
            int currentJ = current[1];
            int stepCount = current[2];
            
            if (currentI == itemY && currentJ == itemX) {
                    answer = stepCount / 2;
                }
            
            for (int i = 0; i < 4; i++) {
                int nextI = currentI + dI[i];
                int nextJ = currentJ + dJ[i];
                
                if (nextI > 0 && nextI < 101 && nextJ > 0 && nextJ < 101) {
                    if (!visited[nextI][nextJ] && map[nextI][nextJ] == 1) {
                        visited[nextI][nextJ] = true;
                        queue.add(new int[]{nextI, nextJ, stepCount + 1});
                    }
                }
            }
        }
     }   
}