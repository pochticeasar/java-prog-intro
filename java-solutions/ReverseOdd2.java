import java.lang.Object;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReverseOdd2 {
    public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int j = 0;
	List<int[]> a = new ArrayList<>();
	List<Integer> size = new ArrayList<>();
        while (sc.hasNextLine()) {
	    Scanner str = new Scanner(sc.nextLine());
	    int i = 0;
	    int[] frst = new int[10];
            int len = 10;
	    while (str.hasNextInt()) {
	        int h = str.nextInt();
		if(i <= len - 1) {
		    frst[i] = h;
		    i++;
		} else {
		    int[] sec = new int[len * 2];
                    System.arraycopy(frst, 0, sec, 0, len);
		    len *= 2;
		    frst = sec;
		    frst[i] = h;
                    i++;
		}
		
	    }
	    a.add(frst);
	    size.add(i);
	    j++;    
	}
	for (int m = j - 1; m >= 0; m--) {
	    int[] help = a.get(m);
	    for (int k = size.get(m) - 1; k >= 0; k--) {
		if((k + m) % 2 == 1) {
	            System.out.print(help[k]);
		    if (k != 0) {
	                System.out.print(" ");
		    }
		}
	    }
	    System.out.print("\n");
	}
    }
}
	
	    