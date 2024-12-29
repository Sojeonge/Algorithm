import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int K;
    static int[] check = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        check[num] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    System.out.println(check[temp]);
                    return;
                }

                if (next >= 0 && next < check.length && check[next] == 0) {
                    q.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }
    }
}

// import java.io.*;
// import java.util.*;

// public class Bfs {
//   static int n, k;
//   static boolean[] visited = new boolean[100001];

//   public static void main(String[] args) throws IOException {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//     n = Integer.parseInt(st.nextToken());
//     k = Integer.parseInt(st.nextToken());

//     if (n == k) {
//       System.out.println(0);
//     } else {
//       bfs(n);
//     }
//   }

//   static void bfs(int start) {
//     Queue<Integer> q = new LinkedList<>();
//     q.add(start);
//     visited[start] = true;

//     int count = 0; // 이동 횟수

//     while (!q.isEmpty()) {
//       int size = q.size(); // 현재 레벨의 노드 수

//       for (int i = 0; i < size; i++) {
//         int cur = q.poll();

//         // 목표에 도달하면 현재 이동 횟수를 출력
//         if (cur == k) {
//           System.out.println(count);
//           return;
//         }

//         // 다음 위치 탐색
//         for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
//           if (next >= 0 && next < visited.length && !visited[next]) {
//             visited[next] = true;
//             q.add(next);
//           }
//         }
//       }

//       // 한 레벨의 탐색이 끝난 후 이동 횟수 증가
//       count++;
//     }
//   }
// }

