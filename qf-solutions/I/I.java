import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class I {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
            h[i] = in.nextInt();
        }
        int xl = x[0] - h[0], xr = x[0] + h[0], yl = y[0] - h[0], yr = y[0] + h[0];
        for (int i = 1; i < n; i++) {
            xl = Math.min(x[i] - h[i], xl);
            xr = Math.max(x[i] + h[i], xr);
            yl = Math.min(y[i] - h[i], yl);
            yr = Math.max(y[i] + h[i], yr);
        }
        int height = (Math.max(xr - xl, yr - yl) + 1) / 2;
        System.out.println((xl + xr)/2 + " " + (yl + yr)/2 + " " + height);
    }
}