import java.io.*;
import java.util.*;

public class Main {
  static int[][] map;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // String[] str = br.readLine().split(" ");
    // int n = Integer.parseInt(str[0]);
    // int m = Integer.parseInt(str[1]);

    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j] = input.charAt(j) -'0';
      }
    }

    boolean visited[][] = new boolean[n][m];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {0, 0});
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int nowX = now[0];
      int nowY = now[1];

      for (int i = 0; i < 4; i++) {
        int nx = nowX + dx[i];
        int ny = nowY + dy[i];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 0)
          continue;

        visited[nx][ny] = true;
        queue.add(new int[] {nx, ny});
        map[nx][ny] = map[nowX][nowY] + 1; // 최단거리로 카운팅
      }
    }
    System.out.println(map[n-1][m-1]);

  }

}
