package expression;

public class Add extends Operation {
    ExpressionElement left, right;
    public Add(ExpressionElement left, ExpressionElement right) {
        super(left, right);
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return toString(" + ");
    }

    @Override
    public boolean equals(Object hz) {
        if(hz instanceof Add) {
            if(((Add) hz).left.equals(this.left) && ((Add) hz).right.equals(this.right))
                return true;
            return false;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return left.hashCode() * 5 + right.hashCode() * 7;
    }
    @Override
    public int evaluate(int a) {
        int[] arg = evaluateArguments(a);
        return arg[0] + arg[1];
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return left.evaluate(x, y, z) + right.evaluate(x,y, z);
    }
}
