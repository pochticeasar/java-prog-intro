import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseAbc2 {
    public static void main(String args[]) {
        FastScanner sc = new FastScanner(System.in);
        int j = 0;
        int[][] a = new int[1][];
        while (sc.hasNextLine()) {
            FastScanner str = new FastScanner(sc.nextLine());
            int i = 0;
            int[] frst = new int[10];
            int len = 10;
            while (str.hasNext()) {
                String h = str.next();
                StringBuilder hz = new StringBuilder();
                for (int it = 0; it < h.length(); it++) {
                    if(Character.isLetter(h.charAt(it))) {
                        hz.append(Character.toLowerCase(h.charAt(it)));
                    }
                    else hz.append(h.charAt(it));
                }
                h = hz.toString();
                int abc = 0;
                int st = 0;
                StringBuilder ans = new StringBuilder();
                if (h.charAt(0) == '-') {
                    st++;
                    ans.append('-');
                }
                for (int it = st; it < h.length(); it++) {
                    if(Character.isLetter(h.charAt(it)))
                        ans.append(h.charAt(it) - 'a');
                }
                abc = Integer.parseInt(ans.toString());
                if (i <= len - 1) {
                    frst[i] = abc;
                    i++;
                } else {
                    int[] sec = Arrays.copyOf(frst, len * 2);
                    len *= 2;
                    frst = sec;
                    frst[i] = abc;
                    i++;
                }
            }
            int[] fin = Arrays.copyOf(frst, i);
            if (j + 1 > a.length)
                a = Arrays.copyOf(a, a.length * 2);
            a[j] = fin;
            j++;
        }
        for (int m = j - 1; m >= 0; m--) {
            int[] help = a[m];
            int sz = help.length;
            for (int k = sz - 1; k >= 0; k--) {
                System.out.print(help[k]);
                if (k != 0) {
                    System.out.print(" ");
                }
            }
            System.out.print(System.lineSeparator());
        }
    }
}