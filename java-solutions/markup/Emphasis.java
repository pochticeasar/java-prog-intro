package markup;

import java.util.List;

public class Emphasis extends Element implements actions {
    public Emphasis (List<actions> arg) {
        super(arg);
    }
    @Override
    public void toMarkdown(StringBuilder out) {
        toMarkdown(out, "*");
    }
    @Override
    public void toBBCode(StringBuilder out) {
        toBBCode(out, "[i]", "[/i]");
    }
}