package expression;

public class Variable extends Element {
    String varName;

    public Variable (String s) {
        super(s);
        this.varName = s;
    }

    @Override
    public String toString() {
        return varName;
    }

    @Override
    public boolean equals(Object hz) {
        if(hz instanceof Variable) {
            if(((Variable) hz).varName.equals(this.varName))
                return true;
            return false;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return varName.hashCode() * 5;
    }
    @Override
    public int evaluate(int a) {
        return a;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        if (varName.equals("x")) {
            return x;
        } else if(varName.equals("y")) {
            return y;
        } else {
            return z;
        }
    }
}
