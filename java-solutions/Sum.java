public class Sum {
    public static void main(String[] args) {
        int n = args.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {   
            int term = 0;
	    int l = 0;
            int size = args[i].length();
            for (int j = 0; j < size; j++) {
                if(Character.isDigit(args[i].charAt(j)) || (args[i].charAt(j) == '-' && l == 0)) {
        	    l++;
                } else if(l > 0) {
                    term = Integer.parseInt(args[i].substring(j - l, j));
                    sum += term;
                    l = 0;
                    if (args[i].charAt(j) == '-') {
      		        l++;
        	    }
                 }
            }
            if(l > 0) {
                term = Integer.parseInt(args[i].substring(size - l, size));
                sum += term;
  	    } 
    	}
	System.out.println(sum);
    }
}