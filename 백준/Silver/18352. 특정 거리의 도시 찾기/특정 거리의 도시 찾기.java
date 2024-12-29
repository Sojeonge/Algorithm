import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    List<Integer>[] list = new List[n + 1];
    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list[a].add(b);
    }

    int[] distance = new int[n + 1];
    Arrays.fill(distance, -1);
    distance[x] = 0;

    Queue<Integer> q = new LinkedList<>();
    q.add(x);

    while (!q.isEmpty()) {
      int current = q.poll();

      for (int next : list[current]) {
        if (distance[next] == -1) {
          distance[next] = distance[current] + 1;
          q.add(next);
        }
      }
    }

    boolean found = false;
    for (int i = 1; i <= n; i++) {
      if (distance[i] == k) {
        System.out.println(i);
        found = true;
      }
    }
   if (!found) {
     System.out.println(-1);
   }
  }
}