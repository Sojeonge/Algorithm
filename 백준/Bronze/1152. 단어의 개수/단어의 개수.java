import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        int count = 0;
        String[] words = string.split(" ");
        for(String word : words) {
            if(!word.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}

