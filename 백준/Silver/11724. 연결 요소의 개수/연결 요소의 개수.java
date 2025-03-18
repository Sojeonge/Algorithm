import java.io.*;
import java.util.*;

public class Main {

  static int result;
  static boolean[] check;
  static int n, m;
  static int[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n+1][n+1];
    check = new boolean[n+1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[a][b] = arr[b][a] = 1;
    }

    for (int i = 1; i <= n; i++) {
      if (!check[i]) {
        dfs(i);
        result++;
      }
    }

    System.out.println(result);
  }

  public static void dfs(int num) {
    check[num] = true;
    for (int i = 1; i <= n; i++) {
      if (!check[i] && arr[num][i] == 1) {
        dfs(i);
      }
    }
  }
}