import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] str = br.readLine().split(" ");
    int[] arr = new int[n + 1];
    int[] dp = new int[n + 1];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(str[i]);
      dp[i] = 1;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] < arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    int result = 0;
    for (int i = 0; i < dp.length; i++) {
      result = Math.max(result, dp[i]);
    }

    System.out.println(result);
  }
}