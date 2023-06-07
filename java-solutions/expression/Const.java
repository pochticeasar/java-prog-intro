package expression;

public class Const extends Element {
    int value;
    public Const (int s) {
        super(Integer.toString(s));
        this.value = s;
    }

    @Override
    public String toString() {
        return toString("");
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Const) {
            if(((Const) obj).value == this.value)
                return true;
            return false;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(value) * 29;
    }
    @Override
    public int evaluate(int a) {
        return value;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return value;
    }
}
