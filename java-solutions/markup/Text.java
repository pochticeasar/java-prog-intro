package markup;


public class Text implements actions {
    private String s;
    public Text(String m) {
        this.s = m;
    }
    @Override
    public void toMarkdown(StringBuilder out) {
        out.append(s);
    }
    @Override
    public void toBBCode(StringBuilder out) {
        out.append(s);
    }
}