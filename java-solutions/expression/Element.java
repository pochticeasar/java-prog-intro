package expression;


abstract class Element implements ExpressionElement {
    String arg;
    public Element(String arg) {
        this.arg = arg;
    }

    public String toString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(arg);
        return sb.toString();
    }
}
