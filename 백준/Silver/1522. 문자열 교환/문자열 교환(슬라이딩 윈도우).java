import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split("");

    int aCnt = 0;
    for (int i = 0; i < str.length; i++) {
      if (str[i].equals("a")) aCnt++;
    }

    int start = 0;
    int end = aCnt - 1;

    int bCnt = 0;
    for (int i = 0; i < aCnt; i++) {
      if (str[i].equals("b")) bCnt++;
    }

    int min = bCnt;
    while (start < str.length) { // 슬라이딩 윈도우
      if (str[++end % str.length].equals("b")) bCnt++;
      if (str[start++].equals("b")) bCnt--;

      min = Math.min(min, bCnt);
    }

    System.out.println(min);
  }
}
