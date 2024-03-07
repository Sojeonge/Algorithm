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
        if((N % 100) < 10) {
            System.out.println("0" + (N % 100));
        } else {
            System.out.println((N % 100));
        }
    }

}
