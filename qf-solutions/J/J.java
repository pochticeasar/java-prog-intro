import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            String s = in.next();
            for (int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    for (int k = j + 1; k < n; k++)
                        a[i][k] = (10 + (a[i][k] - a[j][k])) % 10;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j]);
            System.out.println();
        }
    }
}