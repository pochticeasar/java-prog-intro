package expression;

public class Divide extends Operation {
    ExpressionElement left, right;
    public Divide(ExpressionElement left, ExpressionElement right) {
        super(left, right);
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return toString(" / ");
    }

    @Override
    public boolean equals(Object hz) {
        if(hz instanceof Divide) {
            if (((Divide) hz).left.equals(this.left) && ((Divide) hz).right.equals(this.right))
                return true;
            return false;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return (left.hashCode() * 13) + (right.hashCode() * 19);
    }
    public int evaluate(int a) throws ArithmeticException {
        int[] arg = evaluateArguments(a);
        return arg[0] / arg[1];
    }


    @Override
    public int evaluate(int x, int y, int z) {
        return left.evaluate(x, y, z) / right.evaluate(x,y, z);
    }
}
