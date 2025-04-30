import java.io.*;
import java.util.StringTokenizer;

public class Main {

//  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static boolean[] visited;
  static int[] arr;
  static BufferedWriter bw;


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    visited = new boolean[N + 1];
    arr = new int[M];

    dfs(0);

//    System.out.print(sb);

    bw.close(); // bw.flush() 포함 되어있음! 생략 가능
  }

  private static void dfs(int depth) throws IOException {

    // 1. BuilderedWriter 사용
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        bw.write(arr[i] + (i == M - 1 ? "" : " "));
      }
      bw.newLine();
      return;
    }

    // 2. StringBuilder 사용
    //    if (depth == M) {
    //      for (int i : arr) {
    //        sb.append(i).append(" ");
    //      }
    //      sb.append("\n");
    //      return;
    //    }

    // 3. System.out.print() 바로 사용하기, StringBuilder 사용 x
    // if (depth == M) {
    //   for (int i = 0; i < M; i++) {
    //     System.out.print(arr[i]);
    //     if (i != M - 1) System.out.print(" ");
    //   }
    //   System.out.println();
    //   return;
    // }

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
