package expression;

public class Multiply extends Operation {
    ExpressionElement left, right;
    public Multiply(ExpressionElement left, ExpressionElement right) {
        super(left, right);
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return toString(" * ");
    }

    public int evaluate(int a) {
        int[] arg = evaluateArguments(a);
        return arg[0] * arg[1];
    }
    @Override
    public int hashCode() {
        return (left.hashCode() * 23) + (right.hashCode() * 7);
    }
    @Override
    public boolean equals(Object hz) {
        if(hz instanceof Multiply) {
            if(((Multiply) hz).left.equals(this.left) && ((Multiply) hz).right.equals(this.right))
                return true;
            return false;
        }
        return false;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return left.evaluate(x, y, z) * right.evaluate(x,y, z);
    }
}
