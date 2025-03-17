import java.util.*;
import java.io.*;

public class Main {
  static StringBuilder sb = new StringBuilder();
  static int N, M, V;
  static int[][] arr;
  static boolean[] check;
  static Queue<Integer> q = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    arr = new int[N+1][N+1];
    check = new boolean[N+1];

    for (int i = 0; i < M; i++) {
      StringTokenizer str = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(str.nextToken());
      int b = Integer.parseInt(str.nextToken());

      arr[a][b] = arr[b][a] = 1;
    }

    dfs(V);
    sb.append("\n");
    check = new boolean[N+1];
    bfs(V);

    System.out.println(sb);
  }

  public static void dfs(int V) {
    check[V] = true;
    sb.append(V + " ");

    for (int i = 1; i <= N; i++) {
      if (!check[i] && arr[V][i] == 1) {
        dfs(i);
      }
    }
  }

  public static void bfs(int V) {
    q.add(V);
    check[V] = true;

    while(!q.isEmpty()) {
      int v = q.poll();
      sb.append(v + " ");

      for (int i = 1; i <= N; i++) {
        if (!check[i] && arr[v][i] == 1) {
          q.add(i);
          check[i] = true;
        }
      }
    }
  }
}