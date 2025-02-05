import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int N;
  static int count;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    System.out.println(bfs(N)); // BFS <<<<< DP (입력값이 클수도 있기 때문에)
 
  }

  private static int bfs(int N) {
    Queue<Integer> q = new LinkedList<>();
    int[] visited = new int[N + 1];

    q.add(N);
    visited[N] = 1;

    while (!q.isEmpty()) {
      int cur = q.poll();

      if (cur == 1) {
        return visited[cur] - 1;
      }

      if (cur % 3 == 0 && visited[cur / 3]== 0) {
        visited[cur / 3] = visited[cur] + 1;
        q.add(cur / 3);
      }

      if (cur % 2 == 0 && visited[cur / 2] == 0) {
        visited[cur / 2] = visited[cur] + 1;
        q.add(cur / 2);
      }

      if (visited[cur - 1] == 0) {
        visited[cur - 1] = visited[cur] + 1;
        q.add(cur - 1);
      }
    }
    return 0;
  }
}
