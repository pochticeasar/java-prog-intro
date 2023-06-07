package markup;

import java.util.List;

public class Paragraph extends Element implements actions {

    public Paragraph (List<actions> args) {
        super(args);
    }

    @Override
    public void toMarkdown(StringBuilder out) {
        toMarkdown(out, "");
    }

    @Override
    public void toBBCode(StringBuilder out) {
        toBBCode(out, "", "");
    }
}