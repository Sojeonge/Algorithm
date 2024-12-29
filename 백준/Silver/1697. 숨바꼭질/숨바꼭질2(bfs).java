import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int K;
  static int[] time;
  static int cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    time = new int[100_001];

    bfs();
    System.out.println(time[K]);
    System.out.println(cnt);

  }

  static void bfs() {
    Queue<Integer> q = new LinkedList<>();
    q.add(N);

    if (N == K) {
      cnt++;
      return;
    }

    while (!q.isEmpty()) {
      int now = q.poll();

      for (int i = 0; i < 3; i++) {
        int next;
        if (i == 0) next = now - 1;
        else if (i == 1) next = now + 1;
        else next = now * 2;

        if (next > 0 && next < 100_001 && time[next] == 0) {
          time[next] = time[now] + 1;
          q.add(next);
        }

        if (next == K) cnt++;
      }
    }
  }
}
