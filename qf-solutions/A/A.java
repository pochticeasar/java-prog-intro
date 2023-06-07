import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        float a = in.nextInt();
        float b = in.nextInt();
        float n = in.nextInt();
        int c = (int) Math.ceil((n - b)/(b - a));
        System.out.println(2 * c  + 1);
    }
}