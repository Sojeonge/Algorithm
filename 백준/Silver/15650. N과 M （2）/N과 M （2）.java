import java.io.*;
import java.util.*;

public class Main {

  static int N, M;
  static int[] arr;
  static boolean[] visited;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    visited = new boolean[N + 1];

    dfs(0);
  }

  static void dfs(int depth){

    if (depth == M) {
      for (int i = 0; i < M; i++) {
        System.out.print(arr[i]);
        if (i != M - 1) System.out.print(" ");
      }
      System.out.println();
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[depth] = i;
        dfs(depth + 1);

        for (int j = i + 1; j <= N; j++) {
          visited[j] = false;
        }
      }
    }
  }
}