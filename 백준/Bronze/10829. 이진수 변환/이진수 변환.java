import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Long N = Long.parseLong(br.readLine());
    System.out.println(Long.toBinaryString(N));
  }
}

