import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    boolean tag = false;
    for (int i = 0; i < str.length(); i++) {

      if (str.charAt(i) == '<') {
        tag = true;

        if (!stack.isEmpty()) {
          while (!stack.isEmpty()) {
            sb.append(stack.pop());
          }
        }
        sb.append(str.charAt(i));
      }

      else if (str.charAt(i) == '>') {
        tag = false;
        sb.append(str.charAt(i));
      }

      else if (tag == true) {

        sb.append(str.charAt(i));
      }

      else if (tag == false) {
        if (str.charAt(i) == ' ') {

          while (!stack.isEmpty()) {
            sb.append(stack.pop());
          }

          sb.append(" ");
        }

        else {
          stack.add(str.charAt(i));
        }
      }
    }

    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    System.out.println(sb);
  }
}