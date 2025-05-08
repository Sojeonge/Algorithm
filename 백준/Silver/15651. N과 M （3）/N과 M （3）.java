import java.io.*;
import java.util.*;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static int[] arr;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];

    dfs(0);
    System.out.print(sb);
  }

  static void dfs(int depth){

    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(arr[i]);
        if (i != M - 1) sb.append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {

      arr[depth] = i;
      dfs(depth + 1);

    }
  }
}