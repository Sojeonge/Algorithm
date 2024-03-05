import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int t = 0; t < 3; t++) {
            BigInteger S = BigInteger.ZERO;
            int N = scanner.nextInt();

            for(int i = 0; i < N; i++) {
                S = S.add(scanner.nextBigInteger());
            }

            if(S.compareTo(BigInteger.ZERO) > 0) {
                System.out.println("+");
            } else if(S.compareTo(BigInteger.ZERO) < 0) {
                System.out.println("-");
            } else
                System.out.println("0");
        }
    }
}
