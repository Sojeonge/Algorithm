import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    int aCount = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == 'a') aCount++;
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < str.length(); i++) {
      int bCount = 0;
      for (int j = i; j < i + aCount; j++) {
        int idx = j % str.length();
        if (str.charAt(idx) == 'b') bCount++;
      }

      min = Math.min(min, bCount);
    }

    System.out.println(min);
  }
}