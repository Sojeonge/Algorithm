import java.io.*;
import java.util.*;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static Deque<Character> deque = new ArrayDeque<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    boolean tag = false;
    for (int i = 0; i < str.length(); i++) {
      char target = str.charAt(i);
      if (target == '<') {
        clearDeque();
        tag = true;
        deque.add(target);
      }
      else if (target == '>') {
        deque.add(target);
        while (deque.peek() != target) {
          sb.append(deque.pollFirst());
        }
        sb.append(deque.poll());
        tag = false;
      }
      else if (!tag && target == ' ') {
        clearDeque();
        sb.append(target);
      }
      else {
        deque.add(target);
      }
    }

    clearDeque();
    System.out.println(sb);
  }

  private static void clearDeque() {
    while (!deque.isEmpty()) {
      sb.append(deque.pollLast());
    }
  }
}

