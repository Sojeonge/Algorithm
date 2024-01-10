import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int height = h - y; //세로
        int width = w - x; //가로
        int min_x, min_y = 0;
        int result = 0;

        min_x = width > x ? x : width;
        min_y = height > y ? y : height;

        if (min_x >= min_y) {
            result = min_y;
            System.out.println(result);
        }else{
            result = min_x;
            System.out.println(result);
        }
    }
}
