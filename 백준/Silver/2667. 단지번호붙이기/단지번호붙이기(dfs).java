import java.io.*;
import java.util.*;

public class Main {
 static int n;
 static int[][] map;
 static boolean[][] visited;
 static int[] dx = {-1, 0, 1, 0};
 static int[] dy = {0, -1, 0, 1};
 static int count;
 static List<Integer> list = new ArrayList<>();

 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  n = Integer.parseInt(br.readLine());

  map = new int[n][n];
  for (int i = 0; i < n; i++) {
   String input = br.readLine();
   for (int j = 0; j < n; j++) {
    map[i][j] = input.charAt(j) - '0';
   }
  }

  visited = new boolean[n][n];
  for (int i = 0; i < n; i++) {
   for (int j = 0; j < n; j++) {
    if (map[i][j] == 1 && !visited[i][j]) {
     count = 0;
     dfs(i, j);
     list.add(count);
    }
   }
  }
  System.out.println(list.size());
  Collections.sort(list);

  for (int result : list) {
   System.out.println(result);
  }
 }

 static void dfs(int x, int y) {
  visited[x][y] = true;
  count++;

  for (int i = 0; i < 4; i++) {
   int nx = x + dx[i];
   int ny = y + dy[i];

   if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
    if (!visited[nx][ny] && map[nx][ny] == 1) {
     dfs(nx, ny);
    }
   }
}

 }
}
