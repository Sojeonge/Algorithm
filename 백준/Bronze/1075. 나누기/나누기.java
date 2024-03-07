import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int F = scanner.nextInt();

        N -= N % 100;

        while(true) {
            if(N % F == 0) {
                break;
            }
            N++;
        }

        System.out.printf("%02d", (N % 100));
    }

}
