package expression;

public class Subtract extends Operation {
    ExpressionElement left, right;
    public Subtract(ExpressionElement left, ExpressionElement right) {
        super(left, right);
        this.left = left;
        this.right = right;
    }
    @Override
    public String toString() {
        return toString(" - ");
    }

    @Override
    public boolean equals(Object hz) {
        if(hz instanceof Subtract) {
            if (((Subtract) hz).left.equals(this.left) && ((Subtract) hz).right.equals(this.right))
                return true;
            return false;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return left.hashCode() * 31 + right.hashCode() * 17;
    }
    public int evaluate(int a) {
        int[] arg = evaluateArguments(a);
        return arg[0] - arg[1];
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return left.evaluate(x, y, z) - right.evaluate(x,y, z);
    }
}
