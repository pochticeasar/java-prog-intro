import java.io.*;
import java.util.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class WordStatWords {
    public static void main(String args[]) {
        StringBuilder st = new StringBuilder();
        Map<String, Integer> m = new TreeMap<>();
        try {
            Reader in = new BufferedReader(new FileReader(new File(args[0]), StandardCharsets.UTF_8));
            try {
                int h = in.read();
                while (h != -1) {
                    char c = (char) h;
                    if (Character.isLetter(c)) {
                        c = Character.toLowerCase(c);
                        st.append(c);
                    } else if (Character.getType(c) == Character.DASH_PUNCTUATION || h == '\'') {
                        st.append(c);
                    } else if (st.length() > 0) {
                        String s = st.toString();
                        st.delete(0, st.length());
                        if (m.containsKey(s)) {
                            m.put(s, m.get(s) + 1);
                        } else {
                            m.put(s, 1);
                        }
                    }
                    h = in.read();
                    if (h == -1 && st.length() > 0) {
                        String s = st.toString();
                        st.delete(0, st.length());
                        if (m.containsKey(s)) {
                            m.put(s, m.get(s) + 1);
                        } else {
                            m.put(s, 1);
                        }
                    }
                }
                try {
                    Writer out = new FileWriter(args[1], StandardCharsets.UTF_8);
                    try {
                        for (String key : m.keySet()) {
                            Integer value = m.get(key);
                            String v = Integer.toString(value);
                            out.write(key);
                            out.write(" ");
                            out.write(v);
                            out.write("\n");
                        }
                    } finally {
                        out.close();
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Output file not found: " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("Output exception: " + e.getMessage());
                }
            } finally {
                in.close();
            }
        } catch(FileNotFoundException e) {
          System.out.println("Input file not found: " + e.getMessage());
        } catch(IOException e) {
          System.out.println("Input exception: " + e.getMessage());
        }
    }
}