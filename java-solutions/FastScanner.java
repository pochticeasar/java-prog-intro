import java.io.*;

class FastScanner {
    Reader in;
    StringBuilder nI = new StringBuilder();
    StringBuilder nL = new StringBuilder();
    StringBuilder nC = new StringBuilder();
    StringBuilder nW = new StringBuilder();

    public FastScanner(InputStream inst) {
        this.in = new BufferedReader(new InputStreamReader(inst));
    }

    public FastScanner(String hz) {
        this.in = (new StringReader(hz));
    }
    public FastScanner(File f) {
        try {
            try {
                this.in = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            in.close();
        } catch (IOException e){
            System.out.println("Output exception: " + e.getMessage());
        }
    }

    public boolean hasNextLine() {
        try  {
            while (true) {
                int h = in.read();
                char v = (char) h;

                if(h == -1 ) {
                    break;
                }
                nL.append(v);

                if (v == '\n') {
                    break;
                }

            }
            if (!nL.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println("Input exception: " + e.getMessage());
        }
        return false;
    }

    public String nextLine() {
        String s = null;
        if (!nL.isEmpty()) {
            s = nL.toString();
            nL =  new StringBuilder();
        }
        return s;
    }

    public boolean hasNext() {
        try {
            int n = in.read();
            char c = (char) n;
            boolean dg = false;
            if(!Character.isWhitespace(c))
                dg = true;
            while (!(c == ' ' && dg) && c != System.lineSeparator().charAt(0) && n != -1) {
                if(!Character.isWhitespace(c)) {
                    nC.append(c);
                    dg = true;
                }
                n = in.read();
                c = (char) n;
            }
            if (nC.isEmpty()) {
                return false;
            } else {
                return true;
            }
        } catch (IOException e) {
            System.out.println("Wrong format: " + e.getMessage());
            return false;
        }
    }

    public String next() {
        String ans = nC.toString();
        nC =  new StringBuilder();
        return ans;
    }

    public boolean hasNextInt() {
        if (hasNext()) {
            String tok = next();
            for (int i = 0; i < tok.length(); i++) {
                if (Character.isDigit(tok.charAt(i)) || (tok.charAt(i) == '-' && i == 0) || (tok.charAt(i) == ' ' )) {
                    if (Character.isDigit(tok.charAt(i)) || (tok.charAt(i) == '-' && i == 0)) {
                        nI.append(tok.charAt(i));
                    }
                } else {
                    nI =  new StringBuilder();
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public boolean hasNextWord()
    {
        try {
            int n = in.read();
            char c = (char) n;
            boolean dg = false;
            while (true) {
                if (Character.isLetter(c) || Character.getType(c) == Character.DASH_PUNCTUATION || n == 39) {
                    if(Character.isLetter(c))
                        c = Character.toLowerCase(c);
                    nW.append(c);
                } else if ((!(Character.isLetter(c) || Character.getType(c) == Character.DASH_PUNCTUATION || n == 39) && !nW.isEmpty()) || n== -1) {
                    break;
                }
                else if(!nW.isEmpty()) {
                    return false;
                }
                n = in.read();
                c = (char) n;
            }
            if (nW.isEmpty())
                return false;
            else
                return true;
        } catch (IOException e) {
            System.out.println("io" + e.getMessage());
            return false;
        }
    }
    public String nextWord()
    {
        String ans = nW.toString();
        nW =  new StringBuilder();
        return ans;
    }
    public int nextInt () {
        String out = nI.toString();
        nI =  new StringBuilder();
        int m = Integer.parseInt(out);
        return m;
    }
}

