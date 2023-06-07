import java.lang.Object;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Reverse {
    public static void main(String args[]) {
        FastScanner sc = new FastScanner(System.in);
        int j = 0;
        int[][] a = new int[1][];
        while (sc.hasNextLine()) {
            FastScanner str = new FastScanner(sc.nextLine());
            int i = 0;
            int[] frst = new int[10];
            int len = 10;
            while (str.hasNextInt()) {
                int n = str.nextInt();
                if (i <= len - 1) {
                    frst[i] = n;
                    i++;
                } else {
                    int[] sec = Arrays.copyOf(frst, len * 2);
                    len *= 2;
                    frst = sec;
                    frst[i] = n;
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