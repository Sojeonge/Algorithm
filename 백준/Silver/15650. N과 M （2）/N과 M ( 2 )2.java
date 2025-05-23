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

    dfs(1, 0);
  }

  static void dfs(int start, int depth){

    if (depth == M) {
      for (int i = 0; i < M; i++) {
        System.out.print(arr[i]);
        if (i != M - 1) System.out.print(" ");
      }
      System.out.println();
      return;
    }

    for (int i = start; i <= N; i++) {
      
      if (!visited[i]) {
        visited[i] = true;
        arr[depth] = i;
        dfs(i + 1, depth + 1);
        visited[i] = false;
      }
    }
  }
}
