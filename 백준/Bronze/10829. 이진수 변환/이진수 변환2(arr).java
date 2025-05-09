import java.io.*;

public class Main {
  static int[] arr;
  static int index;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Long N = Long.parseLong(br.readLine());
    arr = new int[64]; // long은 64비트 자료형
    index = 0;

    toBinay(N);
  }

  static void toBinay(Long N) {

    if (N == 0) {
      System.out.println(0);
    }

    while (N > 0) {
      arr[index++] = (int) (N % 2);
      N /= 2;
    }

    for (int i = index - 1; i >= 0; i--) {
      System.out.print(arr[i]);
    }
  }
}
