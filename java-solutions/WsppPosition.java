import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;


public class WsppPosition{
    public static void main(String args[]) {
        Map<String, ArrayList<pair>> m = new LinkedHashMap<>();
        String input = args[0];
        int stcnt = 0;
        FastScanner in = new FastScanner(new File(input));
        while (in.hasNextLine()) {
            stcnt++;
            int cnt = 0;
            String inp = in.nextLine();
            FastScanner str = new FastScanner(inp);
            while(str.hasNextWord())
            {
                cnt++;
                String s = str.nextWord();
                if (m.containsKey(s)) {
                    ArrayList<pair> help = m.get(s);
                    pair p = new pair(stcnt, cnt);
                    help.add(p);
                    m.put(s, help);
                } else {
                    ArrayList<pair> help = new ArrayList<>();
                    pair p = new pair(stcnt, cnt);
                    help.add(p);
                    m.put(s, help);
                }
            }

        }
        in.close();
        try {
            Writer out = new FileWriter(args[1], StandardCharsets.UTF_8);
            try {
                for (String key : m.keySet()) {
                    ArrayList<pair> value = m.get(key);
                    out.write(key);
                    out.write(" ");
                    String size = Integer.toString(value.size());
                    out.write(size);
                    out.write(" ");
                    for (int i = 0; i < value.size(); i++)
                    {
                        String first = Integer.toString(value.get(i).first());
                        out.write(first);
                        out.write(':');
                        String second = Integer.toString(value.get(i).second());
                        out.write(second);
                        if(i != value.size() - 1)
                            out.write(" ");
                    }
                    out.write(System.lineSeparator());
                }
            } finally {
                out.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Output file not found: " + e.getMessage());
        } catch(IOException e){
            System.out.println("Output exception: " + e.getMessage());
        }
    }
}
