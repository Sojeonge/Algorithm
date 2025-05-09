import java.io.*;

public class Main {
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Long N = Long.parseLong(br.readLine());
    System.out.println(toBinay(N));
  }

  static String toBinay(Long N) {
    if (N == 1) {
      sb.append(N);
      return sb.reverse().toString();

    }

    if (N == 0) {
      return sb.reverse().toString();
    }

    sb.append(N % 2);
    N /= 2;
    return toBinay(N);
  }
}
