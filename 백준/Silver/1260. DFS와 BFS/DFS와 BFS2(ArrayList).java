import java.util.*;
import java.io.*;

public class Main {
  static int n, m, start;
  static ArrayList<Integer> arr[];
  static boolean[] check;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(st.nextToken());

    arr = new ArrayList[n+1];
    check = new boolean[n+1];

    for (int i = 0; i < n + 1; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[a].add(b);
      arr[b].add(a);
    }

    for (int i = 0; i < arr.length; i++) {
      Collections.sort(arr[i]);
    }

    dfs(start);
    check = new boolean[n+1];
    sb.append("\n");
    bfs(start);

    System.out.println(sb);
  }

  public static void dfs(int start) {
    check[start] = true;
    sb.append(start + " ");

    for (int i : arr[start]) {
      if (!check[i]) {
        dfs(i);
      }
    }
  }

  public static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    check[start] = true;

    while (!q.isEmpty()) {
      int cur = q.poll();
      sb.append(cur + " ");

      for (int i : arr[cur]) {
        if (!check[i]) {
          q.add(i);
          check[i] = true;
        }
      }
    }
  }
}
