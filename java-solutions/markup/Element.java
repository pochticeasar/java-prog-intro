package markup;

import java.util.*;

public class Element {
    protected List <actions> hz;

    public Element (List <actions> hz) {
        this.hz = hz;
    }
    protected void toMarkdown(StringBuilder out, String mod) {
        out.append(mod);
        for (int i = 0; i < hz.size(); i++)
            hz.get(i).toMarkdown(out);
        out.append(mod);
    }
    protected void toBBCode(StringBuilder out, String begin, String end) {
        out.append(begin);
        for (int i = 0; i < hz.size(); i++)
            hz.get(i).toBBCode(out);
        out.append(end);
    }

}