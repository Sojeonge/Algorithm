import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int sum = 1;
            int result = 0;

            for(int j = 1; j <= b; j++) {
                sum = (sum * a) % 10;
            }

            if(sum == 0) {
                result = 10;
                list.add(result);
            } else {
                result = sum;
                list.add(result);
            }

        }
        for(int x = 0; x < list.size(); x++) {
            System.out.println(list.get(x));
        }

    }

}
