
import java.io.*;
import java.util.*;

public class Main {
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  static int n;
  static int[][] map;

  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < n; j++) {
        map[i][j] = s.charAt(j) - '0';
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        count = 0;
        if (map[i][j] == 1) {
          count++;
          bfs(i,j);
          list.add(count);
        }
      }
    }
    System.out.println(list.size());
    Collections.sort(list);
    for (int result : list) {
      System.out.println(result);
    }
  }

  private static void bfs(int i, int j) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{i,j});
    map[i][j] = 0;

    while(!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0];
      int y = cur[1];

      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];

        if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 1) {
          count++;
          map[nx][ny] = 0;
          q.add(new int[]{nx, ny});
        }
      }
    }
  }
}

// DFS 버전
// import java.io.*;
// import java.util.*;

// public class Main {
//   static int[] dx = {1, -1, 0, 0};
//   static int[] dy = {0, 0, 1, -1};
//   static int n;
//   static int[][] map;

//   static int count;

//   public static void main(String[] args) throws IOException {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     n = Integer.parseInt(br.readLine());
//     map = new int[n][n];
//     List<Integer> list = new ArrayList<>();

//     for (int i = 0; i < n; i++) {
//       String s = br.readLine();
//       for (int j = 0; j < n; j++) {
//         map[i][j] = s.charAt(j) - '0';
//       }
//     }

//     for (int i = 0; i < n; i++) {
//       for (int j = 0; j < n; j++) {
//         count = 0;
//         if (map[i][j] == 1) {
//           count++;
//           map[i][j] = 0;
//           dfs(i,j);
//           list.add(count);
//         }
//       }
//     }
//     System.out.println(list.size());
//     Collections.sort(list);
//     for (int result : list) {
//       System.out.println(result);
//     }
//   }

//   private static void dfs(int i, int j) {
//     for (int k = 0; k < 4; k++) {
//       int nx = i + dx[k];
//       int ny = j + dy[k];

//       if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
//         if (map[nx][ny] == 1) {
//           count++;
//           map[nx][ny] = 0;
//           dfs(nx, ny);
//         }
//       }
//     }
//   }
// }
