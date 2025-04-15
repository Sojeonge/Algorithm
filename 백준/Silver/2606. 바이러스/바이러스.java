import java.io.*;
import java.util.*;

public class Main {
  static int n, m;
  static boolean[] visited;
  static ArrayList<Integer>[] A;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    visited = new boolean[n + 1];

    A = new ArrayList[n + 1];
    for (int i = 1; i < n + 1; i++) {
      A[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      A[a].add(b);
      A[b].add(a);
    }

    dfs(1);
    int count = 0;
    for (int i = 2; i < n + 1; i++) {
      if (visited[i] == true) {
        count++;
      }
    }

    System.out.println(count);
  }

  public static void dfs(int n) {
    if (visited[n] == true) {
      return;
    }

    visited[n] = true;

    for (int i : A[n]) {
      dfs(i);
    }
  }
}