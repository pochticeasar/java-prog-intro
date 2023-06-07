package markup;

import java.util.List;

public class Strong extends Element implements actions {
    public Strong (List<actions> arg) {
        super(arg);
    }
    @Override
    public void toMarkdown(StringBuilder out) {
        toMarkdown(out, "__");
    }
    @Override
    public void toBBCode(StringBuilder out) {
        toBBCode(out, "[b]", "[/b]");
    }
}