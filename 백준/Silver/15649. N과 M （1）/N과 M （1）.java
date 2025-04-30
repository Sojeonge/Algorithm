import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static boolean[] visited;
  static int[] arr;


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    visited = new boolean[N + 1];
    arr = new int[M];

    dfs(0);
    System.out.print(sb);
  }

  private static void dfs(int depth) {
    if (depth == M) {
      for (int i : arr) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[depth] = i;
        dfs(depth + 1);
        visited[i] = false;
      }
    }
  }
}