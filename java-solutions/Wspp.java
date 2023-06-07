import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;


public class Wspp {
    public static void main(String args[]) {
        Map<String, ArrayList<Integer>> m = new LinkedHashMap<>();
        FastScanner in = new FastScanner(new File(args[0]));
        int cnt = 0;
        while (in.hasNextWord()) {
            String s = in.nextWord();
            cnt++;
            if (m.containsKey(s)) {
                ArrayList<Integer> help = m.get(s);
                help.add(cnt);
                m.put(s, help);
            } else {
                ArrayList<Integer> help = new ArrayList<>();
                help.add(cnt);
                m.put(s, help);
            }
        }
        in.close();
        try {
            Writer out = new FileWriter(args[1], StandardCharsets.UTF_8);
            try {
                for (String key : m.keySet()) {
                    ArrayList<Integer> value = m.get(key);
                    out.write(key);
                    out.write(" ");
                    String size = Integer.toString(value.size());
                    out.write(size);
                    out.write(" ");
                    for (int i = 0; i < value.size(); i++) {
                        String v = Integer.toString(value.get(i));
                        out.write(v);
                        if (i != value.size() - 1)
                            out.write(" ");
                    }
                    out.write(System.lineSeparator());
                }
            } finally {
                out.close();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Output file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Output exception: " + e.getMessage());
        }
    }
}