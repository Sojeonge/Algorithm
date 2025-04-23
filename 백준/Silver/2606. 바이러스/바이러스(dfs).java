import java.io.*;
import java.util.*;

public class Main {
  static boolean[] visited;
  static int[][] computers;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    visited = new boolean[n + 1];
    computers = new int[n + 1][n + 1];

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      computers[a][b] = 1;
      computers[b][a] = 1;
    }

    visited[1] = true;
    dfs(1);

    System.out.println(count);
  }

  private static void dfs(int n) {
    System.out.println("dfs(" + n + ") called"); // 재귀호출
    
    for (int i = 1; i < computers.length; i++) {
      if (computers[n][i] == 1 && !visited[i]) {
        visited[i] = true;
        count++;
        dfs(i);
      }
    }
  }
}
