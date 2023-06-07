package markup;

import java.util.List;

public class Strikeout extends Element implements actions {
    public Strikeout(List<actions> arg) {
        super(arg);
    }

    @Override
    public void toMarkdown(StringBuilder out) {
        toMarkdown(out, "~");
    }
    @Override
    public void toBBCode(StringBuilder out) {
        toBBCode(out, "[s]", "[/s]");
    }


}