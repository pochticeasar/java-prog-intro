import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class M {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        // :NOTE: better use for loop
        while(t > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            Map<Integer, Integer> c = new HashMap<>();
            int ax = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                ax = Math.max(ax, a[i]);
            }
            int ans = 0;
            for (int j = n - 2; j >= 1
                    ; j--) {
                Integer ind = a[j + 1];
               // System.out.println("k: " + ind);
                // :NOTE: use c.get(ind) and compare with null
                if(c.containsKey(ind)) {
                    c.replace(ind,  c.get(ind) + 1);
                } else {
                    c.put(ind, 1);
                }
                for (int i = 0; i <= j - 1; i++) {
                    // :NOTE: introduce variable for complex repeated expression
                    if(2 * a[j] - a[i] <= ax && c.containsKey(2 * a[j] - a[i])) {
                        ans += c.get(2 * a[j] - a[i]);
                        //System.out.println("sum: " + (a[i] + a[j]));
                    }
                }
            }
            System.out.println(ans);
            t--;
        }
    }
}