import java.util.*;

class Solution {
    static int[][] map = new int[101][101];
    static int[] dI = {1, -1, 0, 0};
    static int[] dJ = {0, 0, 1, -1};
    static boolean[][] visited = new boolean[101][101];
    static int result = 0;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        drawMap(rectangle);
        
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return result;
    }
    
    static void drawMap(int[][] rectangle) {
        for (int[] rect : rectangle) {
            int startI = rect[1] * 2;
            int endI = rect[3] * 2;
            
            int startJ = rect[0] * 2;
            int endJ = rect[2] * 2;
            
            for(int i=startI;i<=endI;i++)
            {
                for(int j=startJ;j<=endJ;j++)
                {
                    if(i == startI || i == endI || j == startJ || j == endJ)
                    {
                        if(map[i][j] ==2)
                        {
                            continue;
                        }
                        map[i][j] = 1;
                    }
                    else{
                        map[i][j] = 2;
                    }
                }
            }
        }
    }
    static void bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {characterY, characterX, 0});
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentI = current[0];
            int currentJ = current[1];
            int currentStep = current[2];
            
            if (currentI == itemY && currentJ == itemX) {
                result = currentStep / 2;
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextI = currentI + dI[i];
                int nextJ = currentJ + dJ[i];
                
                if (nextI >= 1 && nextI <= 100 && nextJ >= 1 && nextJ <= 100) {
                    if (!visited[nextI][nextJ] && map[nextI][nextJ] == 1) {
                        visited[nextI][nextJ] = true;
                        q.add(new int[]{nextI, nextJ, currentStep + 1});
                    }
                }
            }
        }
    }

}