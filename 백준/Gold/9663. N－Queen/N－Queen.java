import java.io.*;

public class Main {
  static int N;
  static int[] col;
  static int count = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    col = new int[N];

    dfs(0);

    System.out.println(count);
  }

  public static void dfs(int row) {

    if (row == N) {
      count++;
      return;
    }

    for (int i = 0; i < N; i++) {
      col[row] = i;

      if (possible(row)) {
        dfs(row + 1);
      }
    }
  }

  public static boolean possible(int row) {

    for (int i = 0; i < row; i++) {

      if (col[i] == col[row])
        return false;

      if (Math.abs(i - row) == Math.abs(col[i] - col[row]))return false;
    }

    return true;
  }
}