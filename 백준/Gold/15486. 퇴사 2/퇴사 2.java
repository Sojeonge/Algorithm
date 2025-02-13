import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n + 2][2];
    int[] dp = new int[n + 2];

    for (int i = 1; i <= n; i++) {
      String[] str = br.readLine().split(" ");
      int t = Integer.parseInt(str[0]);
      int p = Integer.parseInt(str[1]);
      arr[i][0] = t;
      arr[i][1] = p;
    }

    int max = 0;

    for (int i = 1; i <= n + 1; i++) {
      if (max < dp[i])
        max = dp[i];

      int next = i + arr[i][0];
      int cost = arr[i][1];

      if (next <= n + 1) {
        dp[next] = Math.max(dp[next], max + cost);
      }
    }

    System.out.println(dp[n + 1]);
  }
}